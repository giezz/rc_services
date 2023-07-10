package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.Category;

import java.util.List;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void printAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            System.out.println(category.getType());
        }
    }

    @Test
    public void printCategoryFindById() {
        Category category = categoryRepository.findById(1).orElse(null);
        assert category != null;
        System.out.println(category.getType());
    }
}
