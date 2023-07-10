package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public List<Article> getAllArticles(@RequestParam(name = "header", required = false) String header,
                                                @RequestParam(name = "pubDate", required = false) LocalDate publicationDate,
                                                @RequestParam(name = "pubEndDate", required = false) LocalDate publicationEndDate,
                                                @RequestParam(name = "status", required = false) String status,
                                                @RequestParam(name = "tags", required = false) List<String> tags
    ) {
        return articleService.getByRequest(ArticleRequest.builder()
                .header(header)
                .publicationDate(publicationDate)
                .publicationEndDate(publicationEndDate)
                .status(status)
                .tags(tags)
                .build());
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        return articleService.getById(id);
    }

    @GetMapping("/main")
    public List<Article> getMainArticles() {
        return articleService.getMainArticles();
    }

    @GetMapping("/author/{id}")
    public List<Article> getArticlesByAuthor(@PathVariable("id") List<Integer> ids) {
        return articleService.getByAuthors(ids);
    }

    @PostMapping
    public void addArticle(@RequestBody Article article) {
        articleService.add(article);
    }

    @PutMapping("/{id}")
    public void updateArticle(@PathVariable("id") Integer id,
                              @RequestBody Article articleRequest) {

        Article articleFromDb = articleService.getById(id);

        BeanUtils.copyProperties(articleRequest, articleFromDb, "id");
        articleService.update(articleFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Article article) {
        articleService.delete(article);
    }
}
