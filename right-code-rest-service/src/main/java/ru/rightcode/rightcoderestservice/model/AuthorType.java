package ru.rightcode.rightcoderestservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String type;
}
