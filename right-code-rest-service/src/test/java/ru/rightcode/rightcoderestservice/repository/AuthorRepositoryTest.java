package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.Author;

import java.util.List;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

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
