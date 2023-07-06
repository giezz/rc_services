package ru.rightcode.rightcoderestservicedemo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "external_resource")
public class ExternalResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String link;

    @Column(name = "readable_link")
    private String readableLink;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn (
            name = "resource_type_id",
            referencedColumnName = "id"
    )
    private ResourceType resourceType;
    @ManyToMany(mappedBy = "externalResources")
    private Set<Article> articles;
}
