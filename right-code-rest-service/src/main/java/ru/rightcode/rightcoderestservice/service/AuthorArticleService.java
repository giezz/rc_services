package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.AuthorArticle;
import ru.rightcode.rightcoderestservice.repository.AuthorArticleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorArticleService {
    private final AuthorArticleRepository authorArticleRepository;

    public List<AuthorArticle> getAllAuthorArticles() {
        return authorArticleRepository.findAll();
    }

    public void addAuthorArticle(AuthorArticle authorArticle) {
        authorArticleRepository.save(authorArticle);
    }
}
