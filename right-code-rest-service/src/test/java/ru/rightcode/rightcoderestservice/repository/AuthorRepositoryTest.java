package ru.rightcode.rightcoderestservice.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.Author;

import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

//    @Autowired
//    private EntityManager entityManager;
//
//    @BeforeEach
//    public void setUp() {
//        Author author = Author.builder()
//                .firstNane("FirstName")
//                .middleName("MiddleName")
//                .lastName("LastName")
//                .info("AuthorInfo AuthorInfo AuthorInfo AuthorInfo")
//                .build();
//        entityManager.persist(author);
//    }

    @Test
    public void findAuthorById() {
        Author author = authorRepository.findById(1).get();
        assertEquals(author.getFirstNane(), "FirstName");
    }

    @Test
    public void printAllAuthors() {
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            System.out.println(author.getLastName());
            System.out.println(author.getFirstNane());
            System.out.println(author.getMiddleName());
            System.out.println(author.getInfo());
        }
    }

    @Test
    public void printAuthorFindById() {
        Author author = authorRepository.findById(1).orElse(null);
        assert author != null;
        System.out.println(author.getLastName());
        System.out.println(author.getFirstNane());
        System.out.println(author.getMiddleName());
        System.out.println(author.getInfo());
    }
}
