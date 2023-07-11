package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Page<Article> getByRequest(ArticleRequest articleRequest, Pageable pageable) {

        List<Specification<Article>> specificationList;

        final String header = articleRequest.getHeader();
        final LocalDate publicationDate = articleRequest.getPublicationDate();
        final LocalDate publicationEndDate = articleRequest.getPublicationEndDate();
        final String status = articleRequest.getStatus();

        checkValidDate(publicationDate, publicationEndDate);

        specificationList = Stream.of(
                        Optional.ofNullable(header).map(ArticleSpecification::hasHeader),
                        Optional.ofNullable(publicationDate).map(ArticleSpecification::hasPublicationDate),
                        Optional.ofNullable(publicationEndDate).map(ArticleSpecification::hasPublicationEndDate),
                        Optional.ofNullable(status).map(ArticleSpecification::hasStatus),
                        Optional.ofNullable(articleRequest.getTags()).map(ArticleSpecification::hasTags)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        Specification<Article> articleSpecification = Specification.allOf(specificationList);
        Page<Article> articles = articleRepository.findAll(articleSpecification, pageable);

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

    public Article add(Article article) {
        article.setCreationDate(LocalDate.now());

        checkValidDate(article.getPublicationDate(), article.getPublicationEndDate());

        return articleRepository.save(article);
    }

    public Article update(Article article) {
        return articleRepository.save(article);
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
}
