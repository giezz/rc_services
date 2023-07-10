package ru.rightcode.rightcoderestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private String info;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private Set<Article> articles;

    @ManyToOne
    @JoinColumn(name = "author_type_id")
    private AuthorType authorType;
}
