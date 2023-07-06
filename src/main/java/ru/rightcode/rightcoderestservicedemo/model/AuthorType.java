package ru.rightcode.rightcoderestservicedemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "author_type")
public class AuthorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;
}
