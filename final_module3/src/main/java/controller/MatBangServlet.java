package controller;

import model.LoaiMatBang;
import model.MatBang;
import model.TrangThai;
import repository.impl.MatBangRepository;
import service.impl.IMatbangService;
import service.impl.MatBangService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MatBangServlet", value = "/matbang")
public class MatBangServlet extends HttpServlet {
    IMatbangService matbangService = new MatBangService();
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
//                showeditForm(request, response);
                break;
            case "sort":
                sortMatBang(request, response);
                break;
            case "search":
                doSearch(request, response);
                break;
            case "delete":
                doDeleteForm(request, response);
            default:
                listMatBang(request, response);
                break;
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) {
        String inputSearch = request.getParameter("inputSearch");
        List<MatBang> listSearch = new ArrayList<>();

        listSearch= MatBangRepository.findByName(inputSearch);
        RequestDispatcher dispatcher;
        if (listSearch == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("matBangList", listSearch);
            dispatcher = request.getRequestDispatcher("matbang/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sortMatBang(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> listSort = matbangService.listSort();
        RequestDispatcher dispatcher;
        if (listSort == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("matBangList", listSort);
            dispatcher = request.getRequestDispatcher("matbang/list.jsp");
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
        String maMatBang = request.getParameter("id");
        matbangService.delete(maMatBang);
        listMatBang(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<LoaiMatBang> loaiMatBangList = matbangService.getAllLoaiMatBang();
        List<TrangThai> trangThaiList = matbangService.getAllTrangThai();
        request.setAttribute("loaiMatBangList",loaiMatBangList);
        request.setAttribute("trangThaiList",trangThaiList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("matbang/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangList = matbangService.getAllMatBang();
        request.setAttribute("matBangList",matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("matbang/list.jsp");
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
                createMatBang(request, response);
                break;
            case "edit":
//                editSanPham(request, response);
                break;
            case "delete":
//                doDeleteForm(request, response);
                break;
            default:
                break;
        }
    }



    private void createMatBang(HttpServletRequest request, HttpServletResponse response) {

        String maMatBang = request.getParameter("maMB");
        float dienTich = Float.parseFloat(request.getParameter("dienTich"));
        String trangThai = request.getParameter("trangThai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        String moTa = request.getParameter("moTa");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String ngayBD = request.getParameter("ngayBD");
        String ngayKT = request.getParameter("ngayKT");
        MatBang matBang = new MatBang(maMatBang,trangThai,dienTich,tang,loaiVanPhong,gia,ngayBD,ngayKT);
        matbangService.insert(matBang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("matbang/create.jsp");
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

