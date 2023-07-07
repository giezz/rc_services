package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.AuthorArticle;
import ru.rightcode.rightcoderestservice.notfoundexception.AuthorArticleNotFoundException;
import ru.rightcode.rightcoderestservice.repository.AuthorArticleRepository;

import java.util.List;

@RestController
@RequestMapping("/author-article")
@RequiredArgsConstructor
public class AuthorArticleController {
    private final AuthorArticleRepository repository;

    @GetMapping("/all")
    public List<AuthorArticle> getAllAuthorArticles() {
        return repository.findAll();
    }

    // Get one by author_id and article_id
    @GetMapping("/{author_id}/{article_id}")
    public AuthorArticle getAuthorArticleById(@PathVariable(name = "author_id") Integer author_id,
                                              @PathVariable(name = "article_id") Integer article_id) {
        return repository.findById(author_id).orElseThrow(() -> new AuthorArticleNotFoundException(author_id, article_id));
    }

    @PostMapping("/add")
    public AuthorArticle addAuthorArticle(AuthorArticle authorArticle) {
        return repository.save(authorArticle);
    }

    // PutMapping
}
