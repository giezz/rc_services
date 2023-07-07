package ru.rightcode.rightcoderestservice.controller;

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
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleResponse> getAllArticles(@RequestParam(name = "sort", required = false) String sort,
                                                @RequestParam(name = "tags", required = false) List<String> tags) {
        // FIXME сделать по человеческий
        if (sort != null) {
            if (sort.equals("by-status"))
                return articleService.getArticleSortedByStatus();
            if (sort.equals("by-date"))
                return articleService.getArticleSortedByPublicationDate();
            if (sort.equals("by-main"))
                return articleService.getArticleSortedIsMainArticle();
        } else if (tags != null) {
            return articleService.getArticlesByTags(tags);
        }
        return articleService.getAll();
    }

    // TODO: обработать EntityNotFoundException
    @GetMapping("/{id}")
    public ArticleResponse getArticleById(@PathVariable Integer id) {
        return articleService.getById(id);
    }

    // нужен ли?
    // TODO: Get all by header

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @PutMapping("/{id}")
    public void updateArticle(@PathVariable("id") Article articleFromDb,
                              @RequestBody Article article) {
        BeanUtils.copyProperties(article, articleFromDb, "id");
        articleService.updateArticle(articleFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Article article) {
        articleService.deleteArticle(article);
    }

}
