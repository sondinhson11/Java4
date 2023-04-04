package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.ChucVuRepository;
import view_model.QLChiTietSP;
import view_model.QLChucVu;
import view_model.QLCuaHang;
import view_model.QLNhanVien;

import java.io.IOException;

@WebServlet({
        "/chitietSP/index",    // GET
        "/chitietSP/create",   // GET
        "/chitietSP/edit",     // GET
        "/chitietSP/delete",   // GET
        "/chitietSP/store",    // POST
        "/chitietSP/update",   // POST
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository ctspRepo;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChiTietSPRepository();
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
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSP ctsp = this.ctspRepo.findByMa(ma);
        request.setAttribute("ctsp",ctsp);
        request.getRequestDispatcher("/views/chitiet_SP/edit.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        QLChiTietSP ctsp = this.ctspRepo.findByMa(ma);
        this.ctspRepo.delete(ctsp);
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhsachCTSP",this.ctspRepo.findAll());
        request.setAttribute("view", "/views/chitiet_SP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chitiet_SP/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            QLChiTietSP ctsp = new QLChiTietSP();
            BeanUtils.populate(ctsp,request.getParameterMap());
            ctspRepo.insert(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLChiTietSP ctsp = new QLChiTietSP();
            BeanUtils.populate(ctsp,request.getParameterMap());
            ctspRepo.update(ctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/chitietSP/index");
    }
}
