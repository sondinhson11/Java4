package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewmodel.QLCuaHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CuaHangServlet", value = {
        "/cuahang/index", //GET
        "/cuahang/create", //GET
        "/cuahang/store", //POST
        "/cuahang/edit", //GET
        "/cuahang/update", //POST
        "/cuahang/delete", //GET
})
public class CuaHangServlet extends HttpServlet {
    ArrayList<QLCuaHang>list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else{
            this.index(request,response);
        }
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("DSCuaHang",this.list);
        req.getRequestDispatcher("/views/cuahang/index.jsp").forward(req,resp);

    }

    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cuahang/create.jsp").forward(req,resp);
    }

    protected void edit(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cuahang/edit.jsp").forward(req,resp);
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
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("dia_chi");
        String thanhPho = req.getParameter("thanh_pho");
        String quocGia = req.getParameter("quoc_gia");

        System.out.println(ma);
        System.out.println(ten);
        System.out.println(diaChi);
        System.out.println(thanhPho);
        System.out.println(quocGia);
        list.add(new QLCuaHang(ma,ten,diaChi,thanhPho,quocGia));
    }
}
