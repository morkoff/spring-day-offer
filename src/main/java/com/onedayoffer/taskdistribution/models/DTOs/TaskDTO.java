package com.onedayoffer.taskdistribution.models.DTOs;

import com.onedayoffer.taskdistribution.models.TaskStatus;
import com.onedayoffer.taskdistribution.models.TaskType;
import lombok.Data;

@Data
public class TaskDTO {
    private String name;
    private TaskType taskType;
    private TaskStatus status;
    private Integer priority;
    private Integer leadTime;
}
