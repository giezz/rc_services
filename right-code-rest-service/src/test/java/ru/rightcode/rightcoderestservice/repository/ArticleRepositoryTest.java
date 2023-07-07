package ru.rightcode.rightcoderestservice.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void printAllArticles(){
        List<Article> articleList = articleRepository.findAll();
        for (Article article : articleList) {
            System.out.println(article.getCategory());
            System.out.println(article.getTags());
            System.out.println(article.getExternalResources());
        }
    }

    @Test
    @Transactional
    public void printArticleFindById() {
        Article article = articleRepository.findById(1).orElse(null);;
        System.out.println(article.getContent());
        System.out.println(article.getTags());
    }
}