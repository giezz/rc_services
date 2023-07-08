package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceTypeNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ResourceTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceTypeService {

    private final ResourceTypeRepository resourceTypeRepository;

    public List<ResourceType> getAll() {
        return resourceTypeRepository.findAll();
    }

    public ResourceType get(Integer id) {
        return resourceTypeRepository.findById(id).orElseThrow(() -> new ResourceTypeNotFoundException(id));
    }

    public void add(ResourceType resourceType) {
        resourceTypeRepository.save(resourceType);
    }

    public void update(ResourceType resourceType) {
        resourceTypeRepository.save(resourceType);
    }

    public void delete(ResourceType resourceType) {
        resourceTypeRepository.delete(resourceType);
    }
}
