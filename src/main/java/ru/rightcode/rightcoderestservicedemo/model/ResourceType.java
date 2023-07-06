package ru.rightcode.rightcoderestservicedemo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "resource_type")
public class ResourceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "resourceType")
    private Set<ExternalResource> externalResources;
}
