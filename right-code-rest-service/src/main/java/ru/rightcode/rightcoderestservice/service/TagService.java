package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public Tag get(Integer id) {
        return tagRepository.getReferenceById(id);
    }

    public Tag getByName(String name) {
        return tagRepository.findTagByNameIgnoreCase(name);
    }
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public void delete(Integer id) {
        tagRepository.deleteById(id);
    }

    public Tag updateTag(Integer id, Tag tag) {
        return null;
    }
}
