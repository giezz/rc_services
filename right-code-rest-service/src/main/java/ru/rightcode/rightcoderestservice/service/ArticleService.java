package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.dto.ArticleRequest;
import ru.rightcode.rightcoderestservice.exception.data.PublicationDateGreaterThenPublicationEndDateException;
import ru.rightcode.rightcoderestservice.exception.data.PublicationEndDateNotSpecifiedException;
import ru.rightcode.rightcoderestservice.exception.notfound.ArticlesByAuthorNotFoundException;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;
import ru.rightcode.rightcoderestservice.repository.specification.ArticleSpecification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article getById(Integer id) {
        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public List<Article> getByRequest(ArticleRequest articleRequest) {

        List<Specification<Article>> specificationList = new ArrayList<>();

        final String header = articleRequest.getHeader();
        final LocalDate publicationDate = articleRequest.getPublicationDate();
        final LocalDate publicationEndDate = articleRequest.getPublicationEndDate();
        final String status = articleRequest.getStatus();

        checkValidDate(publicationDate, publicationEndDate);

        if (header != null)
            specificationList.add(Specification.where(ArticleSpecification.hasHeader(header)));

        if (publicationDate != null)
            specificationList.add(Specification.where(ArticleSpecification.hasPublicationDate(publicationDate)));

        if (publicationEndDate != null)
            specificationList.add(Specification.where(ArticleSpecification.hasPublicationEndDate(publicationEndDate)));

        if (status != null)
            specificationList.add(Specification.where(ArticleSpecification.hasStatus(status)));

        if (articleRequest.getTags() != null)
            specificationList.add(Specification.where(ArticleSpecification.hasTags(articleRequest.getTags())));

        Specification<Article> articleSpecification = Specification.allOf(specificationList);
        List<Article> articles = articleRepository.findAll(articleSpecification);

        if (articles.isEmpty())
            throw new ResourceNotFoundException("resource not found");

        return articles;
    }

    public List<Article> getMainArticles() {
        List<Article> articles = articleRepository.findMainArticles();

        if (articles.isEmpty())
            throw new ResourceNotFoundException("resource not found");

        return articles;
    }

    public List<Article> getByAuthors(List<Integer> ids) {
        List<Article> articles = articleRepository.findArticlesByAuthors(ids);

        if (articles.isEmpty())
            throw new ArticlesByAuthorNotFoundException(ids.toString());

        return articles;
    }

    public void add(Article article) {
        article.setCreationDate(LocalDate.now());

        checkValidDate(article.getPublicationDate(), article.getPublicationEndDate());

        articleRepository.save(article);
    }

    public void update(Article article) {
        articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    private static void checkValidDate(LocalDate publicationDate, LocalDate publicationEndDate) {
        if (publicationDate != null) {
            if (publicationEndDate == null) {
                throw new PublicationEndDateNotSpecifiedException("publicationEndDate must be specified if publicationDate is specified");
            }
            if (publicationDate.isAfter(publicationEndDate) || publicationDate.isEqual(publicationEndDate))
                throw new PublicationDateGreaterThenPublicationEndDateException(
                        "publicationEndDate " + publicationEndDate + " must be greater then publicationDate " + publicationDate
                );
        }
    }

    private List<Specification<Article>> checkRequestParams(ArticleRequest articleRequest) {
        List<Specification<Article>> specificationList = new ArrayList<>();

        return null;
    }
}
