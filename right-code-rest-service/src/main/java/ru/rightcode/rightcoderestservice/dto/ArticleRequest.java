package ru.rightcode.rightcoderestservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleRequest {
    private String header;
    private LocalDate publicationDate;
    private LocalDate publicationEndDate;
    private String status;
    private List<String> tags;
}
