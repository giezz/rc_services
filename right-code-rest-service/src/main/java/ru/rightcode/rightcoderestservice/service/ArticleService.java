package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.dto.ArticleResponse;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.notfoundexception.ArticleNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;

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
                // FIXME так и должно быть с датой?
                .publicationDate(article.getPublicationDate())
                .publicationEndDate(article.getPublicationEndDate())
                .category(article.getCategory())
                .status(article.getStatus())
                .editor(article.getEditor())
                .delete(article.getDelete())
                .tags(article.getTags())
//                .tags(article.getTags().stream().map(Tag::toString).toList())
                .externalResources(article.getExternalResources())
//                .externalResources(article.getExternalResources().stream().map(ExternalResource::toString).toList())
                .build();
    }

}
