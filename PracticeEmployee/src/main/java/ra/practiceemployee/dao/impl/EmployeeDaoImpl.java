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
    public Employee findEmployeeById(Integer _id)
    {
        Connection connection = ConnectDB.getConnection();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("select * from employee " +
                    "where employee.id = ?");
            prepare.setInt(1, _id);
            ResultSet result = prepare.executeQuery();
            if (result.next())
            {
                Employee foundEmployee = new Employee();
                foundEmployee.setId(result.getInt("id"));
                foundEmployee.setName(result.getString("name"));
                foundEmployee.setDob(result.getDate("dob"));
                foundEmployee.setSex(result.getBoolean("sex"));
                foundEmployee.setAvatar(result.getString("avatar"));
                return foundEmployee;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
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
                prepare = connection.prepareStatement("update Employee set name = ?, dob = ?," +
                        "sex = ?, avatar = ? where id = ?");
                prepare.setString(1, employee.getName());
                prepare.setDate(2, new java.sql.Date(employee.getDob().getTime()));
                prepare.setBoolean(3, employee.getSex());
                prepare.setString(4, employee.getAvatar());
                prepare.setInt(5, employee.getId());
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
    public void deleteEmployeeById(Integer id) throws SQLException
    {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement prepare = connection.prepareStatement("delete from employee where employee.id = ?");
        prepare.setInt(1, id);
        prepare.executeUpdate();
    }
}
