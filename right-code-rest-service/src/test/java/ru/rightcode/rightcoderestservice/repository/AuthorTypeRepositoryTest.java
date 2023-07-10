package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.AuthorType;

import java.util.List;

@SpringBootTest
public class AuthorTypeRepositoryTest {

    @Autowired
    private AuthorTypeRepository authorTypeRepository;

    @Test
    public void printAllAuthorTypes() {
        List<AuthorType> authorTypeList = authorTypeRepository.findAll();
        for (AuthorType authorType : authorTypeList) {
            System.out.println(authorType.getType());
        }
    }

    @Test
    public void printAuthorTypeFindById() {
        AuthorType authorType = authorTypeRepository.findById(1).orElse(null);
        assert authorType != null;
        System.out.println(authorType.getType());
    }
}
