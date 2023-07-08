package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.exception.notfound.ExternalResourceNotFoundException;
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
        return externalResourceRepository.findById(id).orElseThrow(() -> new ExternalResourceNotFoundException(id));
    }

    public void add(ExternalResource externalResource) {
        externalResourceRepository.save(externalResource);
    }

    public void update(ExternalResource externalResource) {
        externalResourceRepository.save(externalResource);
    }

    public void delete(ExternalResource externalResource) {
        externalResourceRepository.delete(externalResource);
    }

}
