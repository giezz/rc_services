package ru.rightcode.rightcoderestservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import net.minidev.json.JSONUtil;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.rightcode.rightcoderestservice.dto.ArticleRequest;
import ru.rightcode.rightcoderestservice.model.*;
import ru.rightcode.rightcoderestservice.repository.ArticleRepository;
import ru.rightcode.rightcoderestservice.service.ArticleService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ArticleController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Autowired
    private ObjectMapper objectMapper;

    private Article article;

    private Category category;
    private Set<Author> authors = new HashSet<>();


    @BeforeEach
    public void setUp() {
        article = new Article();
        article.setId(1);
        article.setHeader("Test header");
        article.setContent("Test content");
        article.setPublicationDate(LocalDate.now().plusDays(1));
        article.setPublicationEndDate(LocalDate.now().plusDays(2));
        article.setCreationDate(LocalDate.now());
        article.setIsMainArticle(false);
        article.setIsPubliclyAccessible(true);
        authors.add(
                Author.builder()
                        .id(1)
                        .authorType(
                                AuthorType.builder()
                                        .id(1)
                                        .type("Test author type")
                                        .build()
                        )
                        .firstName("Test first name")
                        .lastName("Test last name")
                        .build());
        article.setAuthors(authors);
        category = Category.builder()
                .id(1)
                .type("Test category")
                .build();
        article.setCategory(category);
        article.setTags(
                Set.of(
                        Tag.builder()
                                .id(3)
                                .name("Test tag")
                                .build()
                )
        );
        article.setStatus(
                Status.builder()
                        .id(1)
                        .name("Test status")
                        .build()
        );

        articleService.add(article);
    }

    @Test
    public void ArticleController_CreateArticleCreated() throws Exception{
        given(articleService.add(ArgumentMatchers.any())).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        ResultActions resultActions = mockMvc.perform(post("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(article)));
        resultActions
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.header").value(article.getHeader()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(article.getContent()))
                .andDo(print());
    }


}