package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
@Repository
public interface ExternalResourceRepository extends JpaRepository<ExternalResource, Integer> {
}
