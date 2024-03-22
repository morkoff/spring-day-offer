package com.onedayoffer.taskdistribution.controllers;

import com.onedayoffer.taskdistribution.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

}
