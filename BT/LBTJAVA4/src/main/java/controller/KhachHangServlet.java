package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.*;

import java.io.*;
import java.util.*;

@WebServlet({
        "/khach-hang/index", //GET
        "/khach-hang/create", //GET
        "/khach-hang/store", //POST
        "/khach-hang/edit", //GET
        "/khach-hang/update", //POST
        "/khach-hang/delete", //GET
})

public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        this.create(req,resp);
    }

    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/khach_hang/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        this.store(req,resp);
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ho = req.getParameter("ho");
        String tenDem = req.getParameter("ten_dem");
        String ten = req.getParameter("ten");
        String ngaySinh = req.getParameter("ngay_sinh");
        String sdt = req.getParameter("sdt");
        String diaChi = req.getParameter("dia_chi");
        String quocGia = req.getParameter("quoc_gia");
        String thanhPho = req.getParameter("thanh_pho");
        String matKhau = req.getParameter("mat_khau");

        QLKhachHang qlkh = new QLKhachHang(ma,ho,tenDem,ten,diaChi,sdt,matKhau,thanhPho,quocGia,ngaySinh);
        list.add(qlkh);
    }
}
