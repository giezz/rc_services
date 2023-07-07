package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Override
    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "tags", "externalResources", "externalResources.resourceType"})
    List<Article> findAll();

    @Query("select a from Article a order by a.status.name")
    List<Article> findAllOrderByStatus();

    @Query("select a from Article a order by a.publicationDate")
    List<Article> findAllOrderByPublicationDate();

    @Query("select a from Article a order by a.isMainArticle")
    List<Article> findAllOrderByIsMainArticle();

    @EntityGraph(attributePaths = {"status", "category", "delete", "editor", "tags", "externalResources", "externalResources.resourceType"})
    @Query(value = "select a from Article a join a.tags t where t.name in (:tags) ")
    List<Article> findArticlesByTag(@Param("tags") List<String> tags);
}
