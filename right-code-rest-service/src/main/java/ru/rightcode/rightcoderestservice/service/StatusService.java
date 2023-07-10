package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.repository.StatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status getById(Integer id) {
        return statusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Status add(Status status) {
        return statusRepository.save(status);
    }

    public Status update(Status status) {
        return statusRepository.save(status);
    }

    public void delete(Status status) {
        statusRepository.delete(status);
    }
}
