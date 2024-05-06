package ra.practiceemployee.dao.impl;

import ra.practiceemployee.dao.IEmployeeDao;
import ra.practiceemployee.model.Employee;
import ra.practiceemployee.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao
{
    @Override
    public List<Employee> displayAll()
    {
        Connection connection = ConnectDB.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("select * from employee");
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next())
            {
                Employee e = new Employee();
                e.setId(resultSet.getInt("id"));
                e.setName(resultSet.getString("name"));
                e.setDob(resultSet.getDate("dob"));
                e.setSex(resultSet.getBoolean("sex"));
                e.setAvatar(resultSet.getString("avatar"));
                employeeList.add(e);
            }
            return employeeList;
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public Employee findEmployeeById(Integer id)
    {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement prepare = null;
        try
        {
            if (employee.getId() == null)
            {
                prepare = connection.prepareStatement("insert into Employee(name, dob, sex,avatar)" +
                        "values (?,?,?,?)");
                prepare.setString(1, employee.getName());
                prepare.setDate(2, new java.sql.Date(employee.getDob().getTime()));
                prepare.setBoolean(3, employee.getSex());
                prepare.setString(4, employee.getAvatar());
            } else
            {

            }
            prepare.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteEmployeeById(Integer id)
    {

    }
}
