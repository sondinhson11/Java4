package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NhanVienRepository;
import viewmodel.QLNhanVien;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name = "NhanViennServlet",value = {
        "/nhanvien/index", //GET
        "/nhanvien/create", //GET
        "/nhanvien/store", //POST
        "/nhanvien/edit", //GET
        "/nhanvien/update", //POST
        "/nhanvien/delete", //GET
})
public class NhanVienServlet extends HttpServlet {
    NhanVienRepository nhanVienRepository;
    public NhanVienServlet(){
        nhanVienRepository = new NhanVienRepository();
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
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSNhanVien",this.nhanVienRepository.findAll());
        request.setAttribute("view", "/views/nhanvien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhanvien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = this.nhanVienRepository.findByMa(ma);
        request.setAttribute("nv",nv);
        request.setAttribute("view", "/views/nhanvien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = this.nhanVienRepository.findByMa(ma);
        this.nhanVienRepository.delete(nv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien nv = new QLNhanVien();
            BeanUtils.populate(nv,request.getParameterMap());
            nhanVienRepository.insert(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien nv = new QLNhanVien();
            BeanUtils.populate(nv,request.getParameterMap());
            nhanVienRepository.update(nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");
    }
}
