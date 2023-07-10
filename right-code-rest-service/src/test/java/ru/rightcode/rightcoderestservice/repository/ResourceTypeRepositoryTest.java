package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.ResourceType;

import java.util.List;

@SpringBootTest
public class ResourceTypeRepositoryTest {

    @Autowired
    private ResourceTypeRepository resourceTypeRepository;

    @Test
    public void printAllResourceTypes() {
        List<ResourceType> resourceTypeList = resourceTypeRepository.findAll();
        for (ResourceType resourceType : resourceTypeList) {
            System.out.println(resourceType.getName());
            System.out.println(resourceType.getExternalResources());
        }
    }

    @Test
    public void printResourceTypeFindById() {
        ResourceType resourceType = resourceTypeRepository.findById(1).orElse(null);
        assert resourceType != null;
        System.out.println(resourceType.getName());
        System.out.println(resourceType.getExternalResources());
    }

}
