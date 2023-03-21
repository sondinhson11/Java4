package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChucVuRepository;
import viewmodel.QLChucVu;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chucvu/index", //GET
        "/chucvu/create", //GET
        "/chucvu/store", //POST
        "/chucvu/edit", //GET
        "/chucvu/update", //POST
        "/chucvu/delete", //GET
})
public class ChucVuServlet extends HttpServlet {
    ChucVuRepository chucVuRepository = new ChucVuRepository();

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

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSChucVu", this.chucVuRepository.findAll());
        request.setAttribute("view", "/views/chucvu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chucvu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu chucVu = this.chucVuRepository.findByMa(ma);
        request.setAttribute("cv", chucVu);
        request.setAttribute("view", "/views/chucvu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu cv = this.chucVuRepository.findByMa(ma);
        this.chucVuRepository.delete(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        System.out.println(ma);
        System.out.println(ten);
        QLChucVu cv = new QLChucVu(ma, ten);
        this.chucVuRepository.insert(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLChucVu cv = new QLChucVu(ma, ten);
        this.chucVuRepository.update(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");

    }
}