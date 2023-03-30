package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repostory.sanphamrepostory;
import view_model.QLKhachHang;
import view_model.QLMauSac;
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
    private sanphamrepostory sprepo;

    public SanPhamServlet() {
        this.sprepo = new sanphamrepostory();
        this.sprepo.insert(new QLSanPham("pha","anh"));
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

        }else{
            this.index(request,response);
        }


    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham sp = this.sprepo.findByMa(ma);
        request.setAttribute("sp",sp);
        request.setAttribute("view","/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham sp = this.sprepo.findByMa(ma);
        this.sprepo.delete(sp);
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.litsSanPhams.add(new QLSanPham("PH1","AAAA"));
//        this.litsSanPhams.add(new QLSanPham("PH2","BBBB"));
        request.setAttribute("danhSachSP",this.sprepo.findAll());
        request.setAttribute("view","/views/san_pham/index.jsp");

        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("update")){
            this.update(request,response);
        }else if(uri.contains("store")){
            this.store(request,response);
        }else {
            response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");

        }    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            QLSanPham vm = new QLSanPham();
            BeanUtils.populate(vm,request.getParameterMap());
            this.sprepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");


    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            QLSanPham vm = new QLSanPham();
            BeanUtils.populate(vm,request.getParameterMap());
            this.sprepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/san-pham/index");


    }
}
