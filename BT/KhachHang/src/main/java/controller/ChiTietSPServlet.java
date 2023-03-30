package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repostory.ChiTietSPRepository;
import repostory.khachhangrepostory;
import view_model.ChiTietSP;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/chitiet-sp/index",    // GET
        "/chitiet-sp/create",   // GET
        "/chitiet-sp/store",    // POST
        "/chitiet-sp/edit",     // GET
        "/chitiet-sp/update",   // POST
        "/chitiet-sp/delete",   // GET
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository ctrp;

    public ChiTietSPServlet() {
        ctrp = new ChiTietSPRepository();
        this.ctrp.insert(new ChiTietSP("SP1",2003,"aaa",100,20000000,300000));
        this.ctrp.insert(new ChiTietSP("SP2",2003,"aaa",100,20000000,300000));
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
             this.eidt(request, response);
        } else if (uri.contains("delete")) {
             this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("danhSach1", this.ctrp.findALL());
        request.setAttribute("view","/views/chitiet_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }



    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/chitiet_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ten_sp = request.getParameter("ten_sp");
        ChiTietSP ctsp = this.ctrp.findMa(ten_sp);
        if(ctsp == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.ctrp.delete(ctsp);
            System.out.println("M di !");
            response.sendRedirect("/KhachHang_war_exploded/chitiet-sp/index");
        }
    }
    protected void eidt(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ten_sp = request.getParameter("ten_sp");
        ChiTietSP ctsp = this.ctrp.findMa(ten_sp);
        request.setAttribute("ctsp",ctsp);
        request.setAttribute("view","/views/chitiet_sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri  =  request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/KhachHang_war_exploded/chitiet-sp/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String tenSP = request.getParameter("ten_sp");
        String namBH = request.getParameter("nam_bh");
        String moTa = request.getParameter("mo_ta");
        String soLuongTon = request.getParameter("slt");
        String giaNhap = request.getParameter("gia_nhap");
        String giaBan = request.getParameter("gia_ban");

        ChiTietSP ctsp = new ChiTietSP(tenSP,Integer.valueOf(namBH),moTa,Integer.valueOf(soLuongTon),Double.valueOf(giaNhap),Double.valueOf(giaBan));
        this.ctrp.insert(ctsp);
        response.sendRedirect("/KhachHang_war_exploded/chitiet-sp/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChiTietSP ctsp = new ChiTietSP();

        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            this.ctrp.update(ctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/chitiet-sp/index");
    }
}