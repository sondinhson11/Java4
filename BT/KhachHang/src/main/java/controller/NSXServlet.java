package controller;

import domain_model.NSXDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repostory.nsxrepostory;
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

    private nsxrepostory nsxrepo;

    public NSXServlet() {
        this.nsxrepo = new nsxrepostory();
    }    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        }else if(uri.contains("edit")){
            this.edit(request, response);

        }else  if (uri.contains("delete")) {
            this.delete(request, response);

        }else{
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSXDomain nsx = this.nsxrepo.findByMa(ma);
        request.setAttribute("nsx",nsx);
        request.setAttribute("view","/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSXDomain nsx = this.nsxrepo.findByMa(ma);
        this.nsxrepo.delete(nsx);
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachNSX",this.nsxrepo.findAll());
        request.setAttribute("view","/views/nsx/index.jsp");

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
            NSXDomain vm = new NSXDomain();
            BeanUtils.populate(vm,request.getParameterMap());
            this.nsxrepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");
        ;


    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String ma = request.getParameter("ma");
            NSXDomain vm = this.nsxrepo.findByMa(ma);
            BeanUtils.populate(vm,request.getParameterMap());
            this.nsxrepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/nsx/index");
        ;


    }
}
