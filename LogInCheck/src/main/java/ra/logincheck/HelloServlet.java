package ra.logincheck;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet
{
    private String message;

    public void init()
    {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = "admin";
        String password = "admin";
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        if (name.equals(userName) && password.equals(userPassword))
        {
//            request.getRequestDispatcher("/Success.jsp").forward(request, response);
            response.sendRedirect("/Success.jsp");
        } else
        {
            String loginFailed = "Đăng nhập thất bại";
            request.setAttribute("failed", loginFailed);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            response.sendRedirect("/index.jsp");
        }
    }

    public void destroy()
    {
    }
}