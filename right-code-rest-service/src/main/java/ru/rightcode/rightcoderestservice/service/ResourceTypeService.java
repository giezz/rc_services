package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.repository.ResourceTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceTypeService {
    private final ResourceTypeRepository resourceTypeRepository;

    public List<ResourceType> getAllResourceTypes() {
        return resourceTypeRepository.findAll();
    }

    public void addResourceType(ResourceType resourceType) {
        resourceTypeRepository.save(resourceType);
    }
}
