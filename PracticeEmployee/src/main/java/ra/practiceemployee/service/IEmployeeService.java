package ra.practiceemployee.service;

import ra.practiceemployee.dto.EmployeeDTO;
import ra.practiceemployee.model.Employee;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService
{
    List<Employee> displayAll();

    Employee findEmployeeById(Integer id);

    void saveEmployee(EmployeeDTO employeeDTO, ServletContext context) throws IOException;

    void deleteEmployeeById(Integer id);
}
