package ru.rightcode.rightcoderestservicedemo.model;

import jakarta.persistence.*;
import ru.rightcode.rightcoderestservicedemo.model.id.AuthorArticleId;

@Entity
@Table(name = "author_article")
public class AuthorArticle {
    @EmbeddedId
    private AuthorArticleId id;
    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(
            name = "id_author",
            referencedColumnName = "id"
    )
    private Author author;
    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(
            name = "article_id",
            referencedColumnName = "id"
    )
    private Article article;
    @ManyToOne
    @JoinColumn(
            name = "author_type_id",
            referencedColumnName = "id"
    )
    private AuthorType authorType;
}
