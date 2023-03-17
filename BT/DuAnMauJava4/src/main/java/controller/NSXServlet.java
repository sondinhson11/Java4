package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NsxRepository;
import viewmodel.QLChucVu;
import viewmodel.QLNSX;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/index", //GET
        "/nsx/create", //GET
        "/nsx/store", //POST
        "/nsx/edit", //GET
        "/nsx/update", //POST
        "/nsx/delete", //GET
})
public class NSXServlet extends HttpServlet {
    NsxRepository nsxRepository = new NsxRepository();
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
        request.setAttribute("DSNSX",this.nsxRepository.findAll());
        request.getRequestDispatcher("/views/nsx/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX chucVu = this.nsxRepository.findByMa(ma);
        request.setAttribute("nsx", chucVu);
        request.getRequestDispatcher("/views/nsx/edit.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX cv = this.nsxRepository.findByMa(ma);
        this.nsxRepository.delete(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
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
        QLNSX nsx = new QLNSX(ma,ten);
        this.nsxRepository.insert(nsx);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLNSX nsx = new QLNSX(ma,ten);
        this.nsxRepository.update(nsx);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
    }
}
