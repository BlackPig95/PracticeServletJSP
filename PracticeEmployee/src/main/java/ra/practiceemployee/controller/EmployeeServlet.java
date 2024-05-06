package ra.practiceemployee.controller;

import ra.practiceemployee.dto.EmployeeDTO;
import ra.practiceemployee.service.IEmployeeService;
import ra.practiceemployee.service.implementation.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB - kích thước bộ nhớ tạm
        maxFileSize = 1024 * 1024 * 5,   // 5MB
        maxRequestSize = 1024 * 1024 * 5 * 10 // 50MB
)
public class EmployeeServlet extends HttpServlet
{
    private static final IEmployeeService employeeManagement = new EmployeeServiceImpl();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null)
        {
            switch (action)
            {
                case "ADD":
                    request.getRequestDispatcher("/employeeview/add.jsp").forward(request, response);
                    break;
                case "LIST":
                    request.setAttribute("list", employeeManagement.displayAll());
                    request.getRequestDispatcher("/employeeview/display.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null)
        {
            switch (action)
            {
                case "ADD":
                    String name = request.getParameter("name");
                    String dob = request.getParameter("dob");
                    String sex = request.getParameter("sex");
                    Part fileAvatar = request.getPart("avatar");
                    try
                    {
                        EmployeeDTO employeeDTO = new EmployeeDTO(null, name, sdf.parse(dob), Boolean.parseBoolean(sex), fileAvatar);
                        employeeManagement.saveEmployee(employeeDTO, getServletContext());
                    } catch (ParseException e)
                    {
                        throw new RuntimeException(e);
                    }
                    //Redirect để cập nhật lại danh sách sau khi thêm mới
                    response.sendRedirect("/EmployeeServlet?action=LIST");
                    break;
            }
        }
    }
}