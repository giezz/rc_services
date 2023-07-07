package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
