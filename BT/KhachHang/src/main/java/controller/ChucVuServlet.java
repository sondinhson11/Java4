package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.ChucVuRepository;
import view_model.QLChucVu;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chuc-vu/index", //GET
        "/chuc-vu/create", //GET
        "/chuc-vu/edit", //GET
        "/chuc-vu/delete", //GET
        "/chuc-vu/store", //POST
        "/chuc-vu/update", //POST
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository;
    public ChucVuServlet(){
        chucVuRepository = new ChucVuRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")) {
            edit(request,response);
        }else if (uri.contains("delete")){
            delete(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chuc_vu/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu qlChucVu = chucVuRepository.findByMa(ma);
        request.setAttribute("cv",qlChucVu);
        request.getRequestDispatcher("/views/chuc_vu/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu qlChucVu = chucVuRepository.findByMa(ma);
        chucVuRepository.delete(qlChucVu);
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");

    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachChucVu",this.chucVuRepository.findAll());
        request.getRequestDispatcher("/views/chuc_vu/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);

        }else{
            update(request,response);
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLChucVu qlChucVu = new QLChucVu(ma,ten);
        chucVuRepository.insert(qlChucVu);
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLChucVu qlChucVu = new QLChucVu(ma,ten);
        chucVuRepository.update(qlChucVu);
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");
    }
}
