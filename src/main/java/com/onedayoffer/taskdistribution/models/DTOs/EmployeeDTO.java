package com.onedayoffer.taskdistribution.models.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private String fio;
    private String jobTitle;
    private List<TaskDTO> tasks;
}
