package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightcode.rightcoderestservice.model.ResourceType;

public interface ResourceTypeRepository extends JpaRepository<ResourceType, Integer> {
}
