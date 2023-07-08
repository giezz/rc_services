package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.service.StatusService;

import java.util.List;

@Controller
@RequestMapping("/status")
@Tag(name = "Status Controller", description = "Контроллер статусов")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping()
    public List<Status> getAll() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    public Status getStatus(@PathVariable("id") Integer id) {
        return statusService.getById(id);
    }

    @PostMapping
    public void addStatus(@RequestBody Status status) {
        statusService.add(status);
    }

    @PutMapping("/{id}")
    public void updateStatus(@PathVariable("id") Status statusFromDb,
                             @RequestBody Status status) {
        statusFromDb.setName(status.getName());
        statusService.update(statusFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable("id") Status status) {
        statusService.delete(status);
    }
}
