package ru.rightcode.rightcoderestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "external_resource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @JsonIgnore
    @ManyToMany(mappedBy = "externalResources")
    private Set<Article> articles;
}
