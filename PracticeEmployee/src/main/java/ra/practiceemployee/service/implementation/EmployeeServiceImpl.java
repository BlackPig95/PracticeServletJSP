package ra.practiceemployee.service.implementation;

import ra.practiceemployee.dao.IEmployeeDao;
import ra.practiceemployee.dao.impl.EmployeeDaoImpl;
import ra.practiceemployee.dto.EmployeeDTO;
import ra.practiceemployee.model.Employee;
import ra.practiceemployee.service.IEmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService
{
    private static final IEmployeeDao employeeDao = new EmployeeDaoImpl();
    //    private static final List<Employee> employeeList = new ArrayList<>();
    private static final String uploadPath = "webapp/uploads";
    private static final String permanentFolder = "D:\\Rikkei_Module3_SQL\\BaiTapJSPServlet\\PracticeEmployee\\src\\main\\webapp\\uploads";

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
        {   //Default avatar
            employeeModel.setAvatar("D:\\Rikkei_Module3_SQL\\BaiTapJSPServlet\\PracticeEmployee\\src\\main\\webapp\\uploads\\default_avatar.jpg");
        } else
        {   //Set lại avatar hiện tại nếu là hành động update
            String updateAvatar = employeeDTO.getFileAvatar().getSubmittedFileName();
            employeeModel.setAvatar(updateAvatar);
        }
        //Trong trường hợp có tải lên file mới thì lấy hình ảnh từ file mới
        Part file = employeeDTO.getFileAvatar();
        if (file != null && file.getSize() != 0)
        {
            employeeModel.setAvatar("/uploads/" + file.getSubmittedFileName());
            file.write(path + File.separator + file.getSubmittedFileName());
//            void write(String fileName)
//    throws IOException
//            A convenience method to write this uploaded item to disk.
//            This method is not guaranteed to succeed if called more than once for the same part. This allows a particular implementation to use, for example, file renaming, where possible, rather than copying all of the underlying data, thus gaining a significant performance benefit.
//                Parameters:
//            fileName - the name of the file to which the stream will be written. The file is created relative to the location as specified in the MultipartConfig
//            Throws:
//            IOException - if an error occurs.
            //=>2nd part.write call may fail
//            file.write(permanentFolder + File.separator + file.getSubmittedFileName());
        }
        employeeDao.saveEmployee(employeeModel);
    }

    @Override
    public void deleteEmployeeById(Integer id)
    {
        employeeDao.deleteEmployeeById(id);
    }

}
