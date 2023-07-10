package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.repository.TagRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Tag getById(Integer id) {
        return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public List<Tag> getAllByName(String name) {
        return tagRepository.findAllByNameIgnoreCaseLike(name);
    }

    public Tag add(Tag tag) {
        return tagRepository.save(tag);
    }

    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }

    public void update(Tag tag) {
        tagRepository.save(tag);
    }
}
