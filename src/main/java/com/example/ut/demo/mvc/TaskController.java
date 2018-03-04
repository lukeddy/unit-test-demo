package com.example.ut.demo.mvc;

import java.util.Set;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ut.demo.domain.User;
import com.example.ut.demo.domain.User.Role;
import com.example.ut.demo.repository.UserRepository;
import com.example.ut.demo.service.WorkerService;

@Validated
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

    @Autowired
    private WorkerService taskService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}/tasks/{tasks}")
    public double[][] cal(@PathVariable Long id, @PathVariable @Size(min = 1, max = 3) Set<Integer> tasks) {

        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Illegal user id: " + id);
        }

        if (user.getRole() != Role.ADMIN) {
            throw new IllegalStateException("user no priority");
        }

        if (tasks.stream().anyMatch(task -> task < 0)) {
            throw new IllegalArgumentException("tasks contains < 0");
        }

        return taskService.task(tasks);
    }

}
