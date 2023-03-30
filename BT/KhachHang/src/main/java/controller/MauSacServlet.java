package controller;

import domain_model.MauSacDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repostory.mausacrepostory;
import view_model.QLChucVu;
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
    private mausacrepostory msrepo;

    public MauSacServlet() {
        this.msrepo = new mausacrepostory();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);

        } else if (uri.contains("edit")) {
            this.edit(request, response);

        } else if (uri.contains("delete")) {
            this.delete(request, response);

        } else {
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSacDomain ms = this.msrepo.findByMa(ma);
        request.setAttribute("ms",ms);
        request.setAttribute("view","/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSacDomain ms = this.msrepo.findByMa(ma);
        this.msrepo.delete(ms);
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachMauSac",this.msrepo.findAll());
        request.setAttribute("view","/views/mau_sac/index.jsp");
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

        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            MauSacDomain vm = new MauSacDomain();
            BeanUtils.populate(vm,request.getParameterMap());
            this.msrepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");

    }
    protected void update(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try{
            String ma = request.getParameter("ma");
            MauSacDomain mauSacDomain = this.msrepo.findByMa(ma);
            BeanUtils.populate(mauSacDomain,request.getParameterMap());
            this.msrepo.update(mauSacDomain);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/mau-sac/index");
    }
}
