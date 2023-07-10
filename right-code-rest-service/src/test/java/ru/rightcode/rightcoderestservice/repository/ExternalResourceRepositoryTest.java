package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.ExternalResource;

import java.util.List;

@SpringBootTest
public class ExternalResourceRepositoryTest {

    @Autowired
    private ExternalResourceRepository externalResourceRepository;

    @Test
    public void printAllExternalResources() {
        List<ExternalResource> externalResourceList = externalResourceRepository.findAll();
        for (ExternalResource externalResource : externalResourceList) {
            System.out.println(externalResource.getReadableLink());
            System.out.println(externalResource.getLink());
            System.out.println(externalResource.getResourceType());
            System.out.println(externalResource.getArticles());
        }
    }

    @Test
    public void printExternalResource(){
        ExternalResource externalResource = externalResourceRepository.findById(1).orElse(null);
        assert externalResource != null;
        System.out.println(externalResource.getReadableLink());
        System.out.println(externalResource.getLink());
        System.out.println(externalResource.getResourceType());
        System.out.println(externalResource.getArticles());
    }
}
