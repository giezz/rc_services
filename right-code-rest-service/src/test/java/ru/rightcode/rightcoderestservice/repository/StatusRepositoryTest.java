package ru.rightcode.rightcoderestservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rightcode.rightcoderestservice.model.Status;

import java.util.List;

@SpringBootTest
public class StatusRepositoryTest {

    @Autowired
    private StatusRepository statusRepository;

    @Test
    public void printAllStatuses() {
        List<Status> statusList = statusRepository.findAll();
        for (Status status : statusList) {
            System.out.println(status);
        }
    }

    @Test
    public void printStatusById() {
        Status status = statusRepository.findById(1).orElse(null);
        assert status != null;
        System.out.println(status.getName());
    }
}
