package controller;

import domain_model.KhachHangDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLKhachHang;
import repostory.khachhangrepostory;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/khach-hang/index", //GET
        "/khach-hang/create", //GET
        "/khach-hang/edit", //GET
        "/khach-hang/delete", //GET
        "/khach-hang/store", //POST
        "/khach-hang/update", //POST
})
public class KhachHangServlet extends HttpServlet {

    private khachhangrepostory khachhangrepostory;
    public KhachHangServlet(){
        this.khachhangrepostory = new khachhangrepostory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);

        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else {
            this.index(request,response);
        }
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHangDomain kh = this.khachhangrepostory.findByMa(ma);
        this.khachhangrepostory.delete(kh);
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHangDomain kh = this.khachhangrepostory.findByMa(ma);
        request.setAttribute("kh", kh);
        request.setAttribute("view","/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachKH",this.khachhangrepostory.findAll());
        request.setAttribute("view","/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
        this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else {
            response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");

        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            KhachHangDomain vm = new KhachHangDomain();
            BeanUtils.populate(vm,request.getParameterMap());
            this.khachhangrepostory.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            KhachHangDomain khachHangDomain = this.khachhangrepostory.findByMa(ma);
            BeanUtils.populate(khachHangDomain,request.getParameterMap());
            this.khachhangrepostory.update(khachHangDomain);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
    }
}
