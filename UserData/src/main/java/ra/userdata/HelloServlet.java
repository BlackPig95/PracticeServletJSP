package ra.userdata;

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
        request.setCharacterEncoding("utf-8");
        UserData user = new UserData(1, "USer 1", "email1", 18);
        request.setAttribute("userdata", user);
        request.getRequestDispatcher("/display.jsp").forward(request, response);
    }

    public void destroy()
    {
    }
}