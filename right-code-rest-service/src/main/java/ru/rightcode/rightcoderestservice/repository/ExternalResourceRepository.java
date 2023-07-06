package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.ExternalResource;

public interface ExternalResourceRepository extends JpaRepository<ExternalResource, Integer> {
}
