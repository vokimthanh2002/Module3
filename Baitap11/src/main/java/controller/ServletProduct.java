package controller;

import models.Product;
import repository.IProductRepository;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct", value = "/product")
public class ServletProduct extends HttpServlet {
    ProductService productService = new IProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showeditForm(request,response);
                break;
            case "delete":
                showdeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = productService.finById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/view.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showdeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = productService.finById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/delete.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showeditForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = productService.finById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/edit.jsp");
        }
        try{
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher =  request.getRequestDispatcher("/create.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAll();
        request.setAttribute("product", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
//                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Float price = Float.valueOf(request.getParameter("price"));
        String image = request.getParameter("image");

        Product product = new Product(id,name,price,image);
        productService.update(id,product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Float price = Float.valueOf(request.getParameter("price"));
        String image = request.getParameter("image");
        int id = (productService.findAll().size());

        Product product = new Product(id,name,price,image);
        productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
