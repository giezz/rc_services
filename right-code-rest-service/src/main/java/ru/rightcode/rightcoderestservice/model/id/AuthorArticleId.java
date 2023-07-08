package ru.rightcode.rightcoderestservice.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class AuthorArticleId implements Serializable {
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "article_id")
    private Integer articleId;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        AuthorArticleId that = (AuthorArticleId) o;
//
//        if (!Objects.equals(authorId, that.authorId)) return false;
//        return Objects.equals(articleId, that.articleId);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = authorId != null ? authorId.hashCode() : 0;
//        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
//        return result;
//    }
}
