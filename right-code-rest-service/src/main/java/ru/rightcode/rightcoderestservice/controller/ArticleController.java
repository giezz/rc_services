package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.assembler.ArticleModelAssembler;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.notfoundexception.ArticleNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository repository;
    private final ArticleModelAssembler assembler;

    @GetMapping("/getall")
    CollectionModel<EntityModel<Article>> all() {
        // EntityModel.of(employee,
        //          linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
        //          linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
        List<EntityModel<Article>> articles = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(java.util.stream.Collectors.toList());
        return CollectionModel.of(articles);
    }

    @GetMapping("/{id}")
    EntityModel<Article> one(@PathVariable Integer id) {
        Article article = repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        return assembler.toModel(article);
    }

    @PostMapping("/add")
    ResponseEntity<?> newArticle(@RequestBody Article newArticle) {
        EntityModel<Article> entityModel = assembler.toModel(repository.save(newArticle));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> replaceArticle(@RequestBody Article newArticle, @PathVariable Integer id) {
        // TODO: add author, tags, resources ...
        Article updatedArticle = repository.findById(id)
                .map(article -> {
                    article.setHeader(newArticle.getHeader());
                    article.setContent(newArticle.getContent());
                    article.setPublicationDate(newArticle.getPublicationEndDate());
                    article.setIsMainArticle(newArticle.getIsMainArticle());
                    article.setIsPubliclyAccessible(newArticle.getIsPubliclyAccessible());
                    return repository.save(article);
                })
                .orElseGet(() -> {
                    newArticle.setId(id);
                    return repository.save(newArticle);
                });
        EntityModel<Article> entityModel = assembler.toModel(updatedArticle);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteArticle(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
