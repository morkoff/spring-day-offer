package com.onedayoffer.taskdistribution.controllers;

import com.onedayoffer.taskdistribution.models.DTOs.EmployeeDTO;
import com.onedayoffer.taskdistribution.models.DTOs.TaskDTO;
import com.onedayoffer.taskdistribution.models.TaskStatus;
import com.onedayoffer.taskdistribution.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("all")
    public List<EmployeeDTO> getAll() {
        logger.info("get all request");
        return employeeService.getEmployees();
    }

    @GetMapping("{id}/tasks")
    public List<TaskDTO> getEmployeeTasks(@PathVariable Integer id) {
        return employeeService.getEmployeeTasks(id);
    }

    @GetMapping("sorted")
    public List<String> getAll(@RequestParam String sort) {
        Sort.Direction direction = sort.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return employeeService.getEmployeesSorted(direction);
    }

    @PostMapping("{id}/task")
    public ResponseEntity getEmployeeTasks(@PathVariable Integer id,
                                           @RequestBody TaskDTO newTask) {
        employeeService.postNewTask(id, newTask);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("{id}/tasks/{taskId}/status")
    public ResponseEntity getEmployeeTasks(@PathVariable Integer id,
                                           @PathVariable Integer taskId,
                                           @RequestParam TaskStatus newStatus) {
        employeeService.updateStatus(id, taskId, newStatus);
        return new ResponseEntity(HttpStatus.OK);
    }
}
