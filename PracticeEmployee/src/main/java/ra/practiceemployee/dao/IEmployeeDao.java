package ra.practiceemployee.dao;

import ra.practiceemployee.dto.EmployeeDTO;
import ra.practiceemployee.model.Employee;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao
{
    List<Employee> displayAll();

    Employee findEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
