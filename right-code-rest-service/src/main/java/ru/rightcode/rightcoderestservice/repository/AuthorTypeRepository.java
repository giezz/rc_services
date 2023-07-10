package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.AuthorType;
@Repository
public interface AuthorTypeRepository extends JpaRepository<AuthorType, Integer> {

}
