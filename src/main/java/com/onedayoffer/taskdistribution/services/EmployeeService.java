package com.onedayoffer.taskdistribution.services;

import com.onedayoffer.taskdistribution.models.DTOs.EmployeeDTO;
import com.onedayoffer.taskdistribution.models.DTOs.TaskDTO;
import com.onedayoffer.taskdistribution.models.TaskStatus;
import com.onedayoffer.taskdistribution.repositories.EmployeeRepository;
import com.onedayoffer.taskdistribution.repositories.entities.Employee;
import com.onedayoffer.taskdistribution.repositories.entities.Task;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        Type listType = new TypeToken<List<EmployeeDTO>>(){}.getType();
        List<EmployeeDTO> employeesDtos =  modelMapper.map(employees, listType);
        return employeesDtos;
    }

    public List<TaskDTO> getEmployeeTasks(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDTO emp =  modelMapper.map(employee, EmployeeDTO.class);
        return emp.getTasks();
    }

    public List<String> getEmployeesSorted(Sort.Direction direction) {
        return employeeRepository.findAllAndSort(Sort.by(direction,"fio"));
    }

    @Transactional
    public void postNewTask(Integer employeeId, TaskDTO newTask) {
        Employee entity = employeeRepository.findById(employeeId).get();
        Task task = modelMapper.map(newTask, Task.class);
        entity.addTask(task);
        employeeRepository.save(entity);
    }

    @Transactional
    public void updateStatus(Integer employeeId, Integer taskId, TaskStatus status) {
        Employee entity = employeeRepository.findById(employeeId).get();
        Task task = entity.getTasks().stream().filter(t -> t.getId() == taskId).findFirst().get();
        task.setStatus(status);
        employeeRepository.save(entity);
    }
}
