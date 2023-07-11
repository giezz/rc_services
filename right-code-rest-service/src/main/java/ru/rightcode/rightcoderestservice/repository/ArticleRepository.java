package ru.rightcode.rightcoderestservice.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Article;

import java.util.List;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

    @Override
    @NotNull
    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "authors", "tags", "externalResources", "externalResources.resourceType"})
    List<Article> findAll();

    @Override
    @NotNull
    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "authors", "tags", "externalResources", "externalResources.resourceType"})
    Page<Article> findAll(@NotNull Specification<Article> articleSpecification, @NotNull Pageable pageable);

    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "authors", "tags", "externalResources", "externalResources.resourceType"})
    @Query("select a from Article a where a.isMainArticle = true")
    List<Article> findMainArticles();

    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "authors", "tags", "externalResources", "externalResources.resourceType"})
    @Query("select a from Article a join a.authors au where au.id in (:ids)")
    List<Article> findArticlesByAuthors(@Param("ids") List<Integer> ids);
}
