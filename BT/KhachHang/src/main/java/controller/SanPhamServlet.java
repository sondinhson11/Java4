package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.SanPhamRepository;
import view_model.QLKhachHang;
import view_model.QLSanPham;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/san-pham/index", //GET
        "/san-pham/create", //GET
        "/san-pham/edit", //GET
        "/san-pham/delete", //GET
        "/san-pham/store", //POST
        "/san-pham/update", //POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepository;

    public SanPhamServlet(){
        spRepository = new SanPhamRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);

        }else if(uri.contains("edit")){
            edit(request,response);
        }else if(uri.contains("delete")){
            delete(request,response);
        }else{
            this.index(request,response);
        }


    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/san_pham/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham qlSanPham = spRepository.findByMa(ma);
        request.setAttribute("sp",qlSanPham);
        request.getRequestDispatcher("/views/san_pham/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham qlSanPham = spRepository.findByMa(ma);
        spRepository.delete(qlSanPham);
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachSP",this.spRepository.findAll());
        request.getRequestDispatcher("/views/san_pham/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")) {
            update(request, response);
        }else{
            this.index(request,response);
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLSanPham qlSanPham = new QLSanPham(ma,ten);
        spRepository.insert(qlSanPham);
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLSanPham qlSanPham = new QLSanPham(ma,ten);
        spRepository.update(qlSanPham);
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");

    }
}
