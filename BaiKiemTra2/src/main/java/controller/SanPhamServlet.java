package controller;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import model.DanhMuc;
import model.SanPham;
import service.ISanPhamService;
import service.impl.SanPhamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = "/sanpham")
public class SanPhamServlet extends HttpServlet {

    ISanPhamService sanPhamService = new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showeditForm(request, response);
                break;
            case "sort":
                sortSanPham(request, response);
                break;
            case "search":
                doSearch(request, response);
                break;
            default:
                listSanPham(request, response);
                break;
        }
    }

    private void sortSanPham(HttpServletRequest request, HttpServletResponse response) {
        List<SanPham> listSort = sanPhamService.sortSanPham();
        RequestDispatcher dispatcher;
        if (listSort == null) {
            dispatcher = request.getRequestDispatcher("sanpham/error-404.jsp");
        } else {
            request.setAttribute("sanPhamList", listSort);
            dispatcher = request.getRequestDispatcher("sanpham/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) {
        String inputSearch = request.getParameter("inputSearch");
        List<SanPham> listSearch = new ArrayList<>();

        listSearch= sanPhamService.findByName(inputSearch);
        RequestDispatcher dispatcher;
        if (listSearch == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("sanPhamList", listSearch);
            dispatcher = request.getRequestDispatcher("sanpham/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        sanPhamService.delete(id);
        listSanPham(request, response);
    }

    private void showeditForm(HttpServletRequest request, HttpServletResponse response) {
        int idSanPham = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamService.findById(idSanPham);
        System.out.println(sanPham);
        RequestDispatcher dispatcher;
        List<DanhMuc> danhMucList = sanPhamService.getAllDanhMuc();
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("sanpham/error-404.jsp");
        } else {
            request.setAttribute("sanpham", sanPham);
            request.setAttribute("listDM", danhMucList);
            dispatcher = request.getRequestDispatcher("sanpham/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<DanhMuc> listDanhMuc = sanPhamService.getAllDanhMuc();
        request.setAttribute("listDM",listDanhMuc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listSanPham(HttpServletRequest request, HttpServletResponse response) {
        List<SanPham> sanPhamList = sanPhamService.getAllSanPham();
        request.setAttribute("sanPhamList",sanPhamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createSanPham(request, response);
                break;
            case "edit":
                editSanPham(request, response);
                break;
            case "delete":
                doDeleteForm(request, response);
                break;
            default:
                break;
        }
    }

    private void editSanPham(HttpServletRequest request, HttpServletResponse response) {
        int idSanPham= Integer.parseInt(request.getParameter("id"));
        String tenSP = request.getParameter("tenSP");
        int idDM = Integer.parseInt(request.getParameter("maDM"));
        Double gia = Double.valueOf(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        String mauSac = request.getParameter("mausac");
        String moTa = request.getParameter("moTa");
        SanPham sanPham = new SanPham(idSanPham,tenSP, gia, soLuong, mauSac, moTa,idDM);
        System.out.println(sanPham);
        sanPhamService.update(sanPham);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createSanPham(HttpServletRequest request, HttpServletResponse response) {
        String tenSP = request.getParameter("tenSP");
        int idDM = Integer.parseInt(request.getParameter("maDM"));
        Double gia = Double.valueOf(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        String mauSac = request.getParameter("mausac");
        String moTa = request.getParameter("moTa");
        SanPham sanPham = new SanPham(tenSP, gia, soLuong, mauSac, moTa,idDM);
        sanPhamService.insert(sanPham);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/create.jsp");
        request.setAttribute("message", "Tao moi san pham thanh cong");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
