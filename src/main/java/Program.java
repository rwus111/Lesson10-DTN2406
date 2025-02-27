import entity.Department;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Program {
    public static void main(String[] args) throws Exception {
        List<Department> departments = getAllDepartments();
        departments.forEach(department -> System.out.println(department));
    }

    public static List<Department> getAllDepartments() throws Exception {
        List<Department> departments = new ArrayList<>();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Department");
        while (resultSet.next()) {
            int id = resultSet.getInt("DepartmentID");
            String name = resultSet.getString("DepartmentName");
            departments.add(new Department(id, name));
        }

        return departments;
    }
}
