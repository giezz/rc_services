package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.AuthorArticle;
@Repository
public interface AuthorArticleRepository extends JpaRepository<AuthorArticle, Integer> {


}
