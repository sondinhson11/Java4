package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import viewmodel.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/khachhang/index", //GET
        "/khachhang/create", //GET
        "/khachhang/store", //POST
        "/khachhang/edit", //GET
        "/khachhang/update", //POST
        "/khachhang/delete", //GET
})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("create")){
            this.create(req,resp);
        }else if(uri.contains("edit")){
            this.edit(req,resp);
        }else{
            this.index(req,resp);
        }

    }
    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("danhSachKH",this.list);
        req.getRequestDispatcher("/views/khachhang/index.jsp").forward(req,resp);
    }
    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/khachhang/create.jsp").forward(req,resp);
    }

    protected void edit(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/khachhang/edit.jsp").forward(req,resp);
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

        System.out.println(ma);
        System.out.println(ho);
        System.out.println(tenDem);
        System.out.println(ten);
        System.out.println(ngaySinh);
        System.out.println(sdt);
        System.out.println(diaChi);
        System.out.println(quocGia);
        System.out.println(thanhPho);
        System.out.println(matKhau);
        QLKhachHang qlkh = new QLKhachHang(ma,ho,tenDem,ten,diaChi,sdt,matKhau,thanhPho,quocGia,ngaySinh);
        list.add(qlkh);
    }
}
