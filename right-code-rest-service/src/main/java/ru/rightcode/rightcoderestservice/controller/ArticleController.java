package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.dto.ArticleResponse;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
@Tag(name = "Article Controller", description = "Контроллер статей")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleResponse> getAllArticles(@RequestParam(name = "sort", required = false) String sort,
                                                @RequestParam(name = "tags", required = false) List<String> tags,
                                                @RequestParam(name = "header", required = false) String header) {
        // FIXME: сделать по человеческий
        if (sort != null) {
            if (sort.equals("by-status"))
                return articleService.getSortedByStatus();
            if (sort.equals("by-date"))
                return articleService.getByPublicationDate();
            if (sort.equals("by-main"))
                return articleService.getSortedIsMainArticle();
        } else if (tags != null) {
            return articleService.getByTags(tags);
        } else if (header != null) {
            return articleService.getByHeader(header);
        }
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public ArticleResponse getArticleById(@PathVariable Integer id) {
        return articleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addArticle(@RequestBody Article article) {
        articleService.add(article);
    }

    @PutMapping("/{id}")
    public void updateArticle(@PathVariable("id") Article articleFromDb,
                              @RequestBody Article article) {
        // FIXME: При обновлении Article, Hibernate почему то удаляет записи из связующих таблиц в отношениях @ManyToMany
        BeanUtils.copyProperties(article, articleFromDb, "id");
        articleService.update(articleFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Article article) {
        articleService.delete(article);
    }

}
