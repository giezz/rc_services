package ru.rightcode.rightcoderestservice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findPopularTags() throws JsonProcessingException {
        Pageable pageable = Pageable.unpaged();
        String result = objectMapper.writeValueAsString(tagRepository.findPopularTags(pageable));
        System.out.println(result);
    }
}