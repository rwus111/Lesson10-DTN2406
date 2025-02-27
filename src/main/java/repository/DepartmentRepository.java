package repository;

import entity.Department;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository{
    @Override
    public List<Department> getAllDepartments() {
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

    @Override
    public Department getDepartmentById(int id) {
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
}
