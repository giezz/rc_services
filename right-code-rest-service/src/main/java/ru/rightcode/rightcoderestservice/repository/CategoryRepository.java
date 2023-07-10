package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
