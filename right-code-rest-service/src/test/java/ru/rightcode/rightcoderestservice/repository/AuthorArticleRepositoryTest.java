package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.AuthorArticle;

import java.util.List;

@SpringBootTest
public class AuthorArticleRepositoryTest {

    @Autowired
    private AuthorArticleRepository authorArticleRepository;

    @Test
    public void printAllAuthorArticles() {
        List<AuthorArticle> authorArticleList = authorArticleRepository.findAll();
        for (AuthorArticle authorArticle : authorArticleList) {
            System.out.println(authorArticle.getAuthor());
            System.out.println(authorArticle.getArticle());
        }
    }

    @Test
    public void printAuthorArticleFindById() {
        AuthorArticle authorArticle = authorArticleRepository.findById(1).orElse(null);
        assert authorArticle != null;
        System.out.println(authorArticle.getAuthor());
        System.out.println(authorArticle.getArticle());
    }
}
