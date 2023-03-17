package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
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
    ArrayList<QLCuaHang> listCuaHang = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            create(request,response);

        }else if (uri.contains("edit")) {
    //
        }else if (uri.contains("delete")){
            //
        }else{
            index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/cua_hang/create.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.listCuaHang);
        request.getRequestDispatcher("/views/cua_hang/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    store(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diachi");
        String thanhpho = request.getParameter("thanhpho");
        String quocgia = request.getParameter("quocgia");

        QLCuaHang qlCuaHang = new QLCuaHang(ma,ten,diachi,thanhpho,quocgia);
        listCuaHang.add(qlCuaHang);
    }
}
