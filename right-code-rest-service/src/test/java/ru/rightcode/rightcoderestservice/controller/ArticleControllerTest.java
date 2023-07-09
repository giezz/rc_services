package ru.rightcode.rightcoderestservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.rightcode.rightcoderestservice.model.Article;
import ru.rightcode.rightcoderestservice.model.Category;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleController articleController;

    private Article article;

    private Category category;



    @BeforeEach
    public void setUp() {
    }
}