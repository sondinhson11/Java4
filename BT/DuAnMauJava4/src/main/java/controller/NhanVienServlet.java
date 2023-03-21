package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewmodel.QLNhanVien;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "NhanViennServlet",value = {
        "/nhanvien/index", //GET
        "/nhanvien/create", //GET
        "/nhanvien/store", //POST
        "/nhanvien/edit", //GET
        "/nhanvien/update", //POST
        "/nhanvien/delete", //GET
})
public class NhanVienServlet extends HttpServlet {
    ArrayList<QLNhanVien>   list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
//        }else if(uri.contains("delete")){
////            this.create(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSNhanVien",this.list);
        request.setAttribute("view", "/views/nhanvien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhanvien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhanvien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
//    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/views/nhanvien/delete.jsp").forward(request,response);
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.store(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String temdem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioi_tinh");
        String ngaySinh =  request.getParameter("ngay_sinh");
        String diaChi = request.getParameter("dia_chi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("mat_khau");
        String idCH = request.getParameter("IdCH");
        String idCV = request.getParameter("IdCV");
        String idGuiBC = request.getParameter("IdGuiBC");

        list.add(new QLNhanVien(ma,ho,temdem,ten,gioiTinh,ngaySinh,diaChi,sdt,matKhau,idCH,idCV,idGuiBC));
    }
}
