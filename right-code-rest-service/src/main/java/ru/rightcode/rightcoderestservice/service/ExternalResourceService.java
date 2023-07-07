package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.repository.ExternalResourceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalResourceService {
    private final ExternalResourceRepository externalResourceRepository;

    public List<ExternalResource> getAllExternalResources() {
        return externalResourceRepository.findAll();
    }

    public void addExternalResource(ExternalResource externalResource) {
        externalResourceRepository.save(externalResource);
    }
}
