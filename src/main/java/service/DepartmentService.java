package service;

import entity.Department;
import repository.DepartmentRepository;
import repository.IDepartmentRepository;

import java.util.List;

public class DepartmentService implements IDepartmentService{
    private IDepartmentRepository departmentRepository = new DepartmentRepository();
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public boolean createDepartment(Department department) {
        return departmentRepository.createDepartment(department);
    }
}
