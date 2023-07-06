package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.AuthorArticle;

public interface AuthorArticleRepository extends JpaRepository<AuthorArticle, Integer> {
}
