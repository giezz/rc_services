package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void printAllTags() {
        System.out.println(tagRepository.findTagByNameIgnoreCase("медицина").getArticles());
    }

}