package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import view_model.QLChiTietSanPham;
import view_model.QLNhanVien;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chi-tiet-san-pham/index", //GET
        "/chi-tiet-san-pham/create", //GET
        "/chi-tiet-san-pham/edit", //GET
        "/chi-tiet-san-pham/delete", //GET
        "/chi-tiet-san-pham/store", //POST
        "/chi-tiet-san-pham/update", //POST
})
public class ChiTietSanPhamServlet extends HttpServlet {
    ArrayList<QLNhanVien> listNhanVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        create(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chi_tiet_san_pham/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        store(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer idSP = Integer.valueOf(request.getParameter("idSP"));
//        Integer idNsx = Integer.valueOf(request.getParameter("idNsx"));
//        Integer idMauSac = Integer.valueOf(request.getParameter("idMauSac"));
//        Integer idDongSP = Integer.valueOf(request.getParameter("idDongSP"));
//        Integer namBH = Integer.parseInt(request.getParameter("namBH"));
//        String moTa = request.getParameter("moTa");
//        Integer slt = Integer.parseInt(request.getParameter("slt"));
//        Double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
//        Double giaBan = Double.parseDouble(request.getParameter("giaBan"));

    }
}
