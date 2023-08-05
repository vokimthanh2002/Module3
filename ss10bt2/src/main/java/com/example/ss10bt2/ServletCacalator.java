package com.example.ss10bt2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCacalator", value = "/calculator")
public class ServletCacalator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        int op = Integer.parseInt(request.getParameter("op"));
        int result=0;
        switch (op){
            case 1:
                result = number1+ number2;
                break;

            case 2:
                result = number1- number2;
                break;

            case 3:
                result = number1* number2;
                break;

            case 4:
                result = number1 / number2;
                break;
        }
        request.setAttribute("kq",result);
        request.getRequestDispatcher("kq.jsp").forward(request,response);
    }
}
