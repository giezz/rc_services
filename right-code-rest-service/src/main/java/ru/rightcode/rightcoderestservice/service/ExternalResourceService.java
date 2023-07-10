package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.repository.ExternalResourceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalResourceService {

    private final ExternalResourceRepository externalResourceRepository;

    public List<ExternalResource> getAll() {
        return externalResourceRepository.findAll();
    }

    public ExternalResource get(Integer id) {
        return externalResourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public ExternalResource add(ExternalResource externalResource) {
        return externalResourceRepository.save(externalResource);
    }

    public ExternalResource update(ExternalResource externalResource) {
        return externalResourceRepository.save(externalResource);
    }

    public void delete(ExternalResource externalResource) {
        externalResourceRepository.delete(externalResource);
    }

}
