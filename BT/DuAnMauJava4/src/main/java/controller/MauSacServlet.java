package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MauSacRepository;
import viewmodel.QLMauSac;
import viewmodel.QLNSX;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {
        "/mausac/index", //GET
        "/mausac/create", //GET
        "/mausac/store", //POST
        "/mausac/edit", //GET
        "/mausac/update", //POST
        "/mausac/delete", //GET
})
public class MauSacServlet extends HttpServlet {
    MauSacRepository mauSacRepository = new MauSacRepository();
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
        request.setAttribute("DSMauSac",this.mauSacRepository.findAll());
        request.getRequestDispatcher("/views/mausac/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mausac/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac chucVu = this.mauSacRepository.findByMa(ma);
        request.setAttribute("ms", chucVu);
        request.getRequestDispatcher("/views/mausac/edit.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac cv = this.mauSacRepository.findByMa(ma);
        this.mauSacRepository.delete(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");
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
    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLMauSac ms = new QLMauSac(ma,ten);
        this.mauSacRepository.insert(ms);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");

    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLMauSac ms = new QLMauSac(ma,ten);
        this.mauSacRepository.update(ms);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");
    }
}
