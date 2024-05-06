package ra.productdiscountcalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("calculate");
        if (action != null)
        {
            switch (action)
            {
                case "CALCULATE":
                    String description = request.getParameter("description");
                    double productPrice = Double.parseDouble(request.getParameter("price"));
                    double discountPercent = Double.parseDouble(request.getParameter("discount-percent"));
                    double discountAmount = discountPercent * productPrice * 0.01;
                    double discountPrice = productPrice - discountAmount;
                    request.setAttribute("description", description);
                    request.setAttribute("price", productPrice);
                    request.setAttribute("discountPercent", discountPercent);
                    request.setAttribute("discountAmount", discountAmount);
                    request.setAttribute("discountPrice", discountPrice);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/display-discount.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}