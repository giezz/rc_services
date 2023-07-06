package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.AuthorType;

public interface AuthorTypeRepository extends JpaRepository<AuthorType, Integer> {

}
