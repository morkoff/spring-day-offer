package com.onedayoffer.taskdistribution.repositories;

import com.onedayoffer.taskdistribution.repositories.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e.fio FROM Employee e")
    List<String> findAllAndSort(Sort sort);

    Optional<Employee> findById(Integer id);

}
