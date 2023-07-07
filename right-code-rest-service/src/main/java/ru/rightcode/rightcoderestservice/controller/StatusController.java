package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Status;
import ru.rightcode.rightcoderestservice.service.StatusService;

import java.util.List;

@Controller
@RequestMapping("status/")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    @GetMapping("all")
    public List<Status> getAll() {
        return statusService.getAllStatuses();
    }

    @GetMapping("{id}")
    public Status get(@PathVariable(name = "id") Integer id){
        return statusService.get(id);
    }

    @PostMapping("add")
    public void add(@RequestBody Status status) {
        statusService.addStatus(status);
    }
}
