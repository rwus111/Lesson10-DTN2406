package service;

import entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
}
