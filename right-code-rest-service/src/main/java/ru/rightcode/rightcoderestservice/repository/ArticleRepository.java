package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
