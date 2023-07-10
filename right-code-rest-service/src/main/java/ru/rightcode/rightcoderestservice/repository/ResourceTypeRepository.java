package ru.rightcode.rightcoderestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rightcode.rightcoderestservice.model.ResourceType;
@Repository
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Integer> {
}
