package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.notfoundexception.ArticleNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository repository;

    // ------------------------- GetMapping Article -----------------
    // Get all
    // TODO: Sort by status='Опубликован', is_main, public_date
    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ArticleNotFoundException(id));
    }

    // TODO: Get all by header

    // TODO: Get all by tag


    // ------------------------- PostMapping Article -----------------
    @PostMapping("/add")
    public Article addArticle(Article article) {
        return repository.save(article);
    }

    // ------------------------- PutMapping Article -----------------
    // TODO: PutMapping


    // ------------------------- DeleteMapping Article -----------------
    // TODO: DeleteMapping

}
