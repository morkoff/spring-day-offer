package com.onedayoffer.taskdistribution.services;

import com.onedayoffer.taskdistribution.models.DTOs.TaskDTO;
import com.onedayoffer.taskdistribution.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskDTO> getTasks() {
        return null;
    }

}
