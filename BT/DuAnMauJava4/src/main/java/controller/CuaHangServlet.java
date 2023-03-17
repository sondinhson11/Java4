package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.CuaHangRepository;
import viewmodel.QLCuaHang;

import java.io.IOException;

@WebServlet(name = "CuaHangServlet", value = {
        "/cuahang/index", //GET
        "/cuahang/create", //GET
        "/cuahang/store", //POST
        "/cuahang/edit", //GET
        "/cuahang/update", //POST
        "/cuahang/delete", //GET
})
public class CuaHangServlet extends HttpServlet {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setAttribute("DSCuaHang",this.cuaHangRepository.findAll());
        req.getRequestDispatcher("/views/cuahang/index.jsp").forward(req,resp);

    }

    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cuahang/create.jsp").forward(req,resp);
    }


    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang cuaHang = this.cuaHangRepository.findByMa(ma);
        request.setAttribute("ch", cuaHang);
        request.getRequestDispatcher("/views/cuahang/edit.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang ch = this.cuaHangRepository.findByMa(ma);
        this.cuaHangRepository.delete(ch);
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("dia_chi");
        String thanhPho = request.getParameter("thanh_pho");
        String quocGia = request.getParameter("quoc_gia");

        this.cuaHangRepository.insert(new QLCuaHang(ma,ten,diaChi,thanhPho,quocGia));
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("dia_chi");
        String thanhPho = request.getParameter("thanh_pho");
        String quocGia = request.getParameter("quoc_gia");

        this.cuaHangRepository.update(new QLCuaHang(ma,ten,diaChi,thanhPho,quocGia));
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");

    }
}
