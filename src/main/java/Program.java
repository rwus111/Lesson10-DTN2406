import controller.DepartmentController;
import entity.Department;

import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        DepartmentController departmentController = new DepartmentController();

//        List<Department> departments = departmentController.getAllDepartments();
//        departments.forEach(department -> System.out.println(department));

//        Department department = departmentController.getDepartmentById(5);
//        System.out.println(department);

        Department department = new Department("Language AI");
        System.out.println(departmentController.createDepartment(department));
    }
}
