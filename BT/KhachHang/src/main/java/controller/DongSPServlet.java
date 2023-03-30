package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChucVu;
import view_model.QLCuaHang;
import view_model.QLDongSP;
import repostory.dongsprepostory;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/dong-sp/index", //GET
        "/dong-sp/create", //GET
        "/dong-sp/edit", //GET
        "/dong-sp/delete", //GET
        "/dong-sp/store", //POST
        "/dong-sp/update", //POST
})
public class DongSPServlet extends HttpServlet {
    private dongsprepostory dsprepo;
    public DongSPServlet(){
        this.dsprepo= new dongsprepostory();
        this.dsprepo.insert(new QLDongSP("pha","anh"));

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
        QLDongSP dsp = this.dsprepo.findByMa(ma);
        request.setAttribute("dsp",dsp);
        request.setAttribute("view","/views/dong_sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP dsp = this.dsprepo.findByMa(ma);
        this.dsprepo.delete(dsp);
        response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/dong_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("danhSachDongSP",this.dsprepo.findAll());
        request.setAttribute("view","/views/dong_sp/index.jsp");
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
            response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");

        }    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSP vm = new QLDongSP();
            BeanUtils.populate(vm,request.getParameterMap());
            this.dsprepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSP vm = new QLDongSP();
            BeanUtils.populate(vm,request.getParameterMap());
            this.dsprepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");
    }
}
