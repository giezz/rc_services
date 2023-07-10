package ru.rightcode.rightcoderestservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.rightcode.rightcoderestservice.repository.AuthorRepository;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }

    @Test
    void addAuthor() {
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void deleteAuthor() {
    }
}
