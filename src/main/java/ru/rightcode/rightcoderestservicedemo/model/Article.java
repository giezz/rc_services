package ru.rightcode.rightcoderestservicedemo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "article")
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
    private Date publicationDate;
    @Column(name = "publication_end_date")
    @Temporal(TemporalType.DATE)
    private Date publicationEndDate;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "is_main_article")
    private Boolean isMainArticle;
    @Column(name = "is_publicly_accessible")
    private Boolean isPubliclyAccessible;
    @ManyToOne
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
    private Category category;

    @ManyToOne
    @JoinColumn(
            name = "status_id",
            referencedColumnName = "id"
    )
    private Status status;
    @ManyToOne
    @JoinColumn(
            name = "editor_id",
            referencedColumnName = "id"
    )
    private Author editor;
    @ManyToOne
    @JoinColumn(
            name = "delete_id",
            referencedColumnName = "id"
    )
    private Author delete;
    @ManyToMany
    @JoinTable(
            name = "tag_article",
            joinColumns = @JoinColumn(
                    name = "article_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Tag> tags;
    @ManyToMany
    @JoinTable(
            name = "external_resource_article",
            joinColumns = @JoinColumn(
                    name = "article_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "external_resource_id",
                    referencedColumnName = "id"
            )
    )
    private Set<ExternalResource> externalResources;

}
