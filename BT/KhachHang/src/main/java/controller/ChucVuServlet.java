package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChucVu;
import repostory.chucvurepostory;
import view_model.QLCuaHang;

import java.io.IOException;

@WebServlet({
        "/chuc-vu/index", //GET
        "/chuc-vu/create", //GET
        "/chuc-vu/edit", //GET
        "/chuc-vu/delete", //GET
        "/chuc-vu/store", //POST
        "/chuc-vu/update", //POST
})
public class ChucVuServlet extends HttpServlet {
    private chucvurepostory cvrepo;

    public ChucVuServlet() {
        this.cvrepo = new chucvurepostory();
        this.cvrepo.insert(new QLChucVu("pha","anh"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        }else if (uri.contains("delete")){
            this.delete(request, response);
        }else{
            this.index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu cv = this.cvrepo.findByMa(ma);
        request.setAttribute("cv",cv);
        request.setAttribute("view","/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu cv = this.cvrepo.findByMa(ma);
        this.cvrepo.delete(cv);
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");
    }


    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/chuc_vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachChucVu",this.cvrepo.findAll());
        request.setAttribute("view","/views/chuc_vu/index.jsp");
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
            response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");

        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChucVu vm = new QLChucVu();
            BeanUtils.populate(vm,request.getParameterMap());
            this.cvrepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChucVu vm = new QLChucVu();
            BeanUtils.populate(vm,request.getParameterMap());
            this.cvrepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/chuc-vu/index");
    }
}
