package repository;

import entity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
}
