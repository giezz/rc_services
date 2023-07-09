package ru.rightcode.rightcoderestservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rightcode.rightcoderestservice.model.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleResponse {
    private Integer id;
    private String header;
    private String content;
    private LocalDate publicationDate;
    private LocalDate publicationEndDate;
    private LocalDate creationDate;
    private Boolean isMainArticle;
    private Boolean isPubliclyAccessible;
    private Category category;
    private Status status;
    private Author delete;
    private Author editor;
    private Set<Tag> tags;
//    private List<String> tags;
    private Set<ExternalResource> externalResources;
//    private List<String> externalResources;
}
