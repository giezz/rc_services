package ru.rightcode.rightcoderestservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String header;

    @Column
    private String content;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private LocalDate publicationDate;

    @Column(name = "publication_end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate publicationEndDate;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;

    @Column(name = "is_main_article")
    private Boolean isMainArticle;

    @Column(name = "is_publicly_accessible")
    private Boolean isPubliclyAccessible;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Author editor;

    @ManyToOne
    @JoinColumn(name = "delete_id")
    private Author delete;

    @ManyToMany
    @JoinTable(
            name = "tag_article",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @ManyToMany
    @JoinTable(
            name = "external_resource_article",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "external_resource_id")
    )
    private Set<ExternalResource> externalResources;
}
