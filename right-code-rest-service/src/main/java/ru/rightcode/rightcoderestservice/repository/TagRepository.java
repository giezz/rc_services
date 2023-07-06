package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
