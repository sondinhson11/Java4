package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NsxRepository;
import view_model.QLNSX;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nsx/index", //GET
        "/nsx/create", //GET
        "/nsx/edit", //GET
        "/nsx/delete", //GET
        "/nsx/store", //POST
        "/nsx/update", //POST
})
public class NSXServlet extends HttpServlet {
    private NsxRepository nsxRepository;
    public NSXServlet(){
        nsxRepository = new NsxRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            edit(request,response);
        }else  if (uri.contains("delete")) {
            delete(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX qlnsx = nsxRepository.findByMa(ma);
        nsxRepository.delete(qlnsx);
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");

    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX qlnsx = nsxRepository.findByMa(ma);
        request.setAttribute("nsx",qlnsx);
        request.getRequestDispatcher("/views/nsx/edit.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachNSX",this.nsxRepository.findAll());
        request.getRequestDispatcher("/views/nsx/index.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            store(request,response);
        }else if(uri.contains("update")){
            update(request,response);
        }else{
            index(request,response);
        }

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLNSX qlnsx = new QLNSX(ma,ten);
        nsxRepository.insert(qlnsx);
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLNSX qlnsx = new QLNSX(ma,ten);
        nsxRepository.update(qlnsx);
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");

    }
}
