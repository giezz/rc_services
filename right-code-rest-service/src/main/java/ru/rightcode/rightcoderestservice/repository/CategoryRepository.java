package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
