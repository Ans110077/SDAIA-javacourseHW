package Day5;

import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\test\\day1\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";
    private static final String SELECT_ONE_EMPLOYEE = "SELECT * FROM employees WHERE employee_id = ?";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, manager_id = ?, department_id = ? WHERE employee_id = ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE employee_id = ?";

    public void insertEmployee(Employee e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMPLOYEE);
        st.setInt(1, e.getEmployeeId());
        st.setString(2, e.getFirstName());
        st.setString(3, e.getLastName());
        st.setString(4, e.getEmail());
        st.setString(5, e.getPhoneNumber());
        st.setString(6, e.getHireDate());
        st.setString(7, e.getJobId());
        st.setDouble(8, e.getSalary());
        st.setInt(9, e.getManagerId());
        st.setInt(10, e.getDepartmentId());
        st.executeUpdate();
    }

    public void updateEmployee(Employee e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMPLOYEE);
        st.setString(1, e.getFirstName());
        st.setString(2, e.getLastName());
        st.setString(3, e.getEmail());
        st.setString(4, e.getPhoneNumber());
        st.setString(5, e.getHireDate());
        st.setString(6, e.getJobId());
        st.setDouble(7, e.getSalary());
        st.setInt(8, e.getManagerId());
        st.setInt(9, e.getDepartmentId());
        st.setInt(10, e.getEmployeeId());
        st.executeUpdate();
    }

    public void deleteEmployee(int employeeId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMPLOYEE);
        st.setInt(1, employeeId);
        st.executeUpdate();
    }

    public Employee selectEmployee(int employeeId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYEE);
        st.setInt(1, employeeId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new Employee(rs);
        } else {
            return null;
        }
    }

    public ArrayList<Employee> selectAllEmployees() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_EMPLOYEES);
        ResultSet rs = st.executeQuery();
        ArrayList<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            employees.add(new Employee(rs));
        }
        return employees;
    }
}
