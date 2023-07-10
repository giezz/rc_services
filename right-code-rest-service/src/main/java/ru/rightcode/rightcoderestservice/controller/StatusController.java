package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.service.StatusService;

@Controller
@RequestMapping("/status")
@Tag(name = "Status Controller", description = "Контроллер статусов")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(statusService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(statusService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addStatus(@RequestBody Status status) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statusService.add(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable("id") Integer id,
                                          @RequestBody Status status) {
        Status statusFromDb = statusService.getById(id);
        statusFromDb.setName(status.getName());
        return ResponseEntity.status(HttpStatus.OK).body(statusService.update(statusFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable("id") Status status) {
        statusService.delete(status);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
