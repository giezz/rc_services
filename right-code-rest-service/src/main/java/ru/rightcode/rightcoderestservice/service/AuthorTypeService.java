package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.AuthorType;
import ru.rightcode.rightcoderestservice.repository.AuthorTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorTypeService {
    private final AuthorTypeRepository authorTypeRepository;

    public List<AuthorType> getAllAuthorTypes() {
        return authorTypeRepository.findAll();
    }

    public void addAuthorType(AuthorType authorType) {
        authorTypeRepository.save(authorType);
    }
}
