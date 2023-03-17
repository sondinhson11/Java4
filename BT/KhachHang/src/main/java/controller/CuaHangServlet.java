package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.CuaHangRepository;
import view_model.QLCuaHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cua-hang/index", //GET
        "/cua-hang/create", //GET
        "/cua-hang/edit", //GET
        "/cua-hang/delete", //GET
        "/cua-hang/store", //POST
        "/cua-hang/update", //POST
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository;
    public CuaHangServlet(){
        cuaHangRepository = new CuaHangRepository();
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
        request.getRequestDispatcher("/views/cua_hang/create.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang qlCuaHang = cuaHangRepository.findByMa(ma);
        cuaHangRepository.delete(qlCuaHang);
        response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");

    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang qlCuaHang = cuaHangRepository.findByMa(ma);
        request.setAttribute("ch",qlCuaHang);
        request.getRequestDispatcher("/views/cua_hang/edit.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.cuaHangRepository.findAll());
        request.getRequestDispatcher("/views/cua_hang/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            store(request,response);
        }else{
            update(request,response);
        }

    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diaChi");
        String thanhpho = request.getParameter("thanhPho");
        String quocgia = request.getParameter("quocGia");

        QLCuaHang qlCuaHang = new QLCuaHang(ma,ten,diachi,thanhpho,quocgia);
        cuaHangRepository.insert(qlCuaHang);
        response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diaChi");
        String thanhpho = request.getParameter("thanhPho");
        String quocgia = request.getParameter("quocGia");

        QLCuaHang qlCuaHang = new QLCuaHang(ma,ten,diachi,thanhpho,quocgia);
        cuaHangRepository.update(qlCuaHang);
        response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");
    }
}
