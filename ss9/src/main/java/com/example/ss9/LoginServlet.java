package com.example.ss9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ConverterServlet", value = "/convert")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Description = String.valueOf(Float.parseFloat(request.getParameter("description")));
        float Price = Float.parseFloat(request.getParameter("price"));
        float Percent = Float.parseFloat(request.getParameter("percent"));

        float DiscountAmount = (float) (Price*Percent *0.01);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: " + Description + "</h1>");
        writer.println("<h1>Price: " + Price + "</h1>");
        writer.println("<h1>Percent: " + Percent + "</h1>");
        writer.println("<h1>DiscountAmount: " + DiscountAmount + "</h1>");
        writer.println("</html>");
    }
}
