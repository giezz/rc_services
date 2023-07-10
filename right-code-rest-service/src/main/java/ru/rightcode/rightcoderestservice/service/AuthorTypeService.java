package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.AuthorType;
import ru.rightcode.rightcoderestservice.repository.AuthorTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorTypeService {

    private final AuthorTypeRepository authorTypeRepository;

    public List<AuthorType> getAll() {
        return authorTypeRepository.findAll();
    }

    public AuthorType getById(Integer id) {
        return authorTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public AuthorType add(AuthorType authorType) {
        return authorTypeRepository.save(authorType);
    }

    public AuthorType update(AuthorType authorType) {
        return authorTypeRepository.save(authorType);
    }

    public void delete(AuthorType authorType) {
        authorTypeRepository.delete(authorType);
    }
}
