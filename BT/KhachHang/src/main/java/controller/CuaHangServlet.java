package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repostory.cuahangrepostory;

import view_model.QLCuaHang;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cua-hang/index", //GET
        "/cua-hang/create", //GET
        "/cua-hang/edit", //GET
        "/cua-hang/delete", //GET
        "/cua-hang/store", //POST
        "/cua-hang/update", //POST
})
public class CuaHangServlet extends HttpServlet {
    private cuahangrepostory chrepo;

    public CuaHangServlet() {
        this.chrepo = new cuahangrepostory();
        this.chrepo.insert(new QLCuaHang("pha","anh","TB","vn","sd"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            create(request,response);

        }else if (uri.contains("edit")) {
            this.edit(request, response);

        }else if (uri.contains("delete")){
            this.delete(request, response);

        }else{
            index(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang ch = this.chrepo.findByMa(ma);
        request.setAttribute("ch",ch);
        request.setAttribute("view","/views/cua_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang ch = this.chrepo.findByMa(ma);
        this.chrepo.delete(ch);
        request.setAttribute("view","/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/cua_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.chrepo.findAll());
        request.setAttribute("view","/views/cua_hang/index.jsp");
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
            response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");

        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLCuaHang vm = new QLCuaHang();
            BeanUtils.populate(vm,request.getParameterMap());
            this.chrepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLCuaHang vm = new QLCuaHang();
            BeanUtils.populate(vm,request.getParameterMap());
            this.chrepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/cua-hang/index");
    }
}
