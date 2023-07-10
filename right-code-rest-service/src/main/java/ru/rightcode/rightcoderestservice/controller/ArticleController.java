package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.dto.ArticleRequest;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.service.ArticleService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/articles")
@Tag(name = "Article Controller", description = "Контроллер статей")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<?> getAllArticles(@RequestParam(name = "header", required = false) String header,
                                            @RequestParam(name = "pubDate", required = false) LocalDate publicationDate,
                                            @RequestParam(name = "pubEndDate", required = false) LocalDate publicationEndDate,
                                            @RequestParam(name = "status", required = false) String status,
                                            @RequestParam(name = "tags", required = false) List<String> tags
    ) {

        return ResponseEntity.status(HttpStatus.OK).body(
                articleService.getByRequest(ArticleRequest.builder()
                        .header(header)
                        .publicationDate(publicationDate)
                        .publicationEndDate(publicationEndDate)
                        .status(status)
                        .tags(tags)
                        .build())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getById(id));
    }

    @GetMapping("/main")
    public ResponseEntity<?> getMainArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getMainArticles());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<?> getArticlesByAuthor(@PathVariable("id") List<Integer> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getByAuthors(ids));
    }

    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody Article article) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.add(article));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable("id") Integer id,
                              @RequestBody Article articleRequest) {

        Article articleFromDb = articleService.getById(id);

        BeanUtils.copyProperties(articleRequest, articleFromDb, "id");
        return ResponseEntity.status(HttpStatus.OK).body(articleService.update(articleFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Article article) {
        articleService.delete(article);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
