package ru.rightcode.rightcoderestservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.repository.StatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getById(Integer id) {
        return statusRepository.findById(id).orElseThrow();
    }

    public void addStatus(Status status) {
        statusRepository.save(status);
    }
}
