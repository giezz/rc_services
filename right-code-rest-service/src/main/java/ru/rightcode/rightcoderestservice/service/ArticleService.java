package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.dto.ArticleResponse;
import ru.rightcode.rightcoderestservice.exception.sql.PublicationDateGreaterThenPublicationEndDateException;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.exception.notfound.ArticleNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleResponse getById(Integer id) {
        return mapToArticleResponse(articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException(id)));
    }

    public List<ArticleResponse> getAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(this::mapToArticleResponse).toList();
//        return articleRepository.findAll();
    }

    public List<ArticleResponse> getSortedByStatus() {
        List<Article> articles = articleRepository.findAllOrderByStatus();
        return articles.stream().map(this::mapToArticleResponse).toList();
    }

    public List<ArticleResponse> getByPublicationDate() {
        List<Article> articles = articleRepository.findAllOrderByPublicationDate();
        return articles.stream().map(this::mapToArticleResponse).toList();
    }

    public List<ArticleResponse> getSortedIsMainArticle() {
        List<Article> articles = articleRepository.findAllOrderByIsMainArticle();
        return articles.stream().map(this::mapToArticleResponse).toList();
    }

    public List<ArticleResponse> getByTags(List<String> tags) {
        List<Article> articles = articleRepository.findArticlesByTag(tags);
        return articles.stream().map(this::mapToArticleResponse).toList();
    }

    public List<ArticleResponse> getByHeader(String header) {
        List<Article> articles = articleRepository.findArticleByHeader(header);
        return articles.stream().map(this::mapToArticleResponse).toList();
    }

    public void add(Article article) {
        article.setCreationDate(LocalDate.now());
        if (article.getPublicationDate().isAfter(article.getPublicationEndDate()))
            throw new PublicationDateGreaterThenPublicationEndDateException("publicationEndDate must be greater then publicationDate");
        articleRepository.save(article);
    }

    public void update(Article article) {
        articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    private ArticleResponse mapToArticleResponse(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .header(article.getHeader())
                .content(article.getContent())
                .publicationDate(article.getPublicationDate())
                .publicationEndDate(article.getPublicationEndDate())
                .creationDate(article.getCreationDate())
                .isMainArticle(article.getIsMainArticle())
                .isPubliclyAccessible(article.getIsPubliclyAccessible())
                .category(article.getCategory())
                .status(article.getStatus())
                .editor(article.getEditor())
                .delete(article.getDelete())
                .tags(article.getTags())
                .externalResources(article.getExternalResources())
                .build();
    }

}
