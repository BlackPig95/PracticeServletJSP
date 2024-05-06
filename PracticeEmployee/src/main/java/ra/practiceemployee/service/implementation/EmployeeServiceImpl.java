package ra.practiceemployee.service.implementation;

import ra.practiceemployee.dao.IEmployeeDao;
import ra.practiceemployee.dao.impl.EmployeeDaoImpl;
import ra.practiceemployee.dto.EmployeeDTO;
import ra.practiceemployee.model.Employee;
import ra.practiceemployee.service.IEmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService
{
    private static final IEmployeeDao employeeDao = new EmployeeDaoImpl();
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final String uploadPath = "webapp/uploads";

    @Override
    public List<Employee> displayAll()
    {
        return employeeDao.displayAll();
    }

    @Override
    public Employee findEmployeeById(Integer id)
    {
        return employeeDao.findEmployeeById(id);
    }

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO, ServletContext context) throws IOException
    {
        String permanentFolder = "D:\\Rikkei_Module3_SQL\\BaiTapJSPServlet\\PracticeEmployee\\src\\main\\webapp\\uploads";
        Employee employeeModel = new Employee(employeeDTO.getId(), employeeDTO.getName(),
                employeeDTO.getDob(), employeeDTO.getSex(), null);
        String path = context.getRealPath("/uploads");
        System.out.println(path);
        File fileUpload = new File(path);
        if (!fileUpload.exists())
        {
            fileUpload.mkdir();
        }
        if (employeeDTO.getId() == null)
        {
            employeeModel.setAvatar("D:\\Rikkei_Module3_SQL\\BaiTapJSPServlet\\PracticeEmployee\\src\\main\\webapp\\uploads\\default_avatar.jpg");
        } else
        {
//            String updateAvatar = employeeDTO.getFileAvatar().getSubmittedFileName();
//            employeeModel.setAvatar(updateAvatar);
        }
        Part file = employeeDTO.getFileAvatar();
        if (file != null && file.getSize() != 0)
        {
            employeeModel.setAvatar("/uploads/" + file.getSubmittedFileName());
            file.write(permanentFolder + File.separator + file.getSubmittedFileName());
            file.write(path + File.separator + file.getSubmittedFileName());
        }
        employeeDao.saveEmployee(employeeModel);
    }

    @Override
    public void deleteEmployeeById(Integer id)
    {
        employeeDao.deleteEmployeeById(id);
    }

}
