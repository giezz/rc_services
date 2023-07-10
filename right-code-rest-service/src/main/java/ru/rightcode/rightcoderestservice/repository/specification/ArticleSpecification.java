package ru.rightcode.rightcoderestservice.repository.specification;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.model.Tag;

import java.time.LocalDate;
import java.util.List;

@Component
public class ArticleSpecification {

    public static Specification<Article> hasHeader(String header) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("header")),
                "%" + header.toLowerCase() + "%")
        );
    }

    public static Specification<Article> hasPublicationDate(LocalDate date) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("publicationDate"), date));
    }

    public static Specification<Article> hasPublicationEndDate(LocalDate date) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("publicationEndDate"), date));
    }

    public static Specification<Article> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            Join<Article, Status> statusJoin = root.join("status");
            return criteriaBuilder.equal(
                    criteriaBuilder.lower(statusJoin.get("name")),
                    status.toLowerCase()
            );
        };
    }

    public static Specification<Article> hasTags(List<String> tags) {
        return ((root, query, criteriaBuilder) -> {
            Join<Article, Tag> tagJoin = root.join("tags");
            return tagJoin.get("name").in(tags);
        });
    }
}
