package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NhanVienRepository;
import view_model.QLNhanVien;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nhan-vien/index", //GET
        "/nhan-vien/create", //GET
        "/nhan-vien/edit", //GET
        "/nhan-vien/delete", //GET
        "/nhan-vien/store", //POST
        "/nhan-vien/update", //POST

})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository;
    public NhanVienServlet(){
        nhanVienRepository = new NhanVienRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            create(request,response);

        }else if (uri.contains("edit")) {
            edit(request,response);
        }else if (uri.contains("delete")){
            delete(request,response);
        }else{
            index(request,response);
        }



    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nhan_vien/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nhan_vien/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachNV",this.nhanVienRepository);
        request.getRequestDispatcher("/views/nhan_vien/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        store(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matkhau = request.getParameter("matkhau");
        Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
        QLNhanVien qlNhanVien = new QLNhanVien(ma,ten,tenDem,ho,gioiTinh,ngaySinh,diaChi,sdt,matkhau,trangThai);
        nhanVienRepository.insert(qlNhanVien);
        response.sendRedirect("/nhan-vien/index");
    }
}
