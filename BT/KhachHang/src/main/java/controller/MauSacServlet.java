package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.MauSacRepository;
import view_model.QLMauSac;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/mau-sac/index", //GET
        "/mau-sac/create", //GET
        "/mau-sac/edit", //GET
        "/mau-sac/delete", //GET
        "/mau-sac/store", //POST
        "/mau-sac/update", //POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepository;

    public MauSacServlet() {
        msRepository = new MauSacRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            edit(request,response);
        } else if (uri.contains("delete")) {
            delete(request,response);
        } else {
            this.index(request,response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mau_sac/create.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String ma = request.getParameter("ma");
       QLMauSac qlMauSac = msRepository.findByMa(ma);
       request.setAttribute("ms",qlMauSac);
        request.getRequestDispatcher("/views/mau_sac/edit.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac qlMauSac = msRepository.findByMa(ma);
        msRepository.delete(qlMauSac);
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachMauSac",this.msRepository.findAll());
        request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            index(request,response);
        }

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLMauSac qlMauSac = new QLMauSac(ma, ten);
        msRepository.insert(qlMauSac);
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLMauSac qlMauSac = new QLMauSac(ma, ten);
        msRepository.update(qlMauSac);
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");

    }
}
