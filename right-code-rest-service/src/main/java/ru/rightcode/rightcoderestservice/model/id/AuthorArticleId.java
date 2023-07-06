package ru.rightcode.rightcoderestservice.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AuthorArticleId implements Serializable {
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "article_id")
    private Integer articleId;
}
