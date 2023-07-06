package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
