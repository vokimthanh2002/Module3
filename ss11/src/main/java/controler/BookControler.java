package controler;

import bean.Book;
import bean.Category;
import service.BookService;
import service.CategoryService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(name = "BookControler", urlPatterns = "/book")
public class BookControler extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    private CategoryService categoryService= new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action== null){
            action = "list";
        }

        switch (action){
            case "create":
            showCreate(request,response);
//                doCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "list":
                showList(request,response);
                break;
            case "delete":
                break;
            default:
                response.sendRedirect("/book?action=list");
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Book book = bookService.findByID(id);
        request.setAttribute("book",book);
        request.setAttribute("categories",categoryService.finAll());
        try {
            request.getRequestDispatcher("book/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String categoryId = request.getParameter("categoryId");
        Category category = categoryService.finByID(categoryId);
        Book book = new Book(id,name,author,category);
        bookService.saveOrUpdate(book);
        response.sendRedirect("book?action=list");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Category> categories = categoryService.finAll();
        request.setAttribute("categories",categoryService.finAll());
        request.getRequestDispatcher("book/create.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Book> list = new ArrayList<>();
            list = bookService.findAll();
            request.setAttribute("books",bookService.findAll());

            request.getRequestDispatcher("book/list.jsp").forward(request,response);
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action== null){
            response.sendRedirect("/book?action=list");
            return;
        }
        switch (action){
            case "create":
                doCreate(request,response);
                break;
        }
    }
}
