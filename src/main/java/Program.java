import entity.Department;
import utils.JDBCUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Program {
    public static void main(String[] args) throws Exception {
//        List<Department> departments = getAllDepartments();
//        departments.forEach(department -> System.out.println(department));

        Department department = getDepartmentById(5);
        System.out.println(department);
    }

    public static Department getDepartmentById(int id) {
        String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("DepartmentName");
                return new Department(id, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Department");
            while (resultSet.next()) {
                int id = resultSet.getInt("DepartmentID");
                String name = resultSet.getString("DepartmentName");
                departments.add(new Department(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return departments;
    }
}
