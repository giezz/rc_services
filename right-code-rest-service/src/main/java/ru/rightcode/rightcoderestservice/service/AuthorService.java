package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.Author;
import ru.rightcode.rightcoderestservice.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Author add(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Author author) {
        return authorRepository.save(author);
    }

    public void delete(Author author) {
        authorRepository.delete(author);
    }
}
