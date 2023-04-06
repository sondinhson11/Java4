package controller;

import domain_model.CuaHangDomain;
import domain_model.NSXDomain;
import domain_model.SanPhamDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet(name = "CuaHangServlet", value = {
        "/cuahang/index", //GET
        "/cuahang/create", //GET
        "/cuahang/store", //POST
        "/cuahang/edit", //GET
        "/cuahang/update", //POST
        "/cuahang/delete", //GET
})
public class CuaHangServlet extends HttpServlet {
    CuaHangRepository cuaHangRepository;
    String error ;
    String errorTen;
    String errorMa;
    String errorDiaChi;


    public CuaHangServlet(){
        cuaHangRepository = new CuaHangRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
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
        request.setAttribute("trungMa",error);
        request.setAttribute("DSCuaHang",this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/cuahang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("errorDiaChi", errorDiaChi);
        request.setAttribute("view", "/views/cuahang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }


    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHangDomain cuaHang = this.cuaHangRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("errorDiaChi", errorDiaChi);
        request.setAttribute("ch", cuaHang);
        request.setAttribute("view", "/views/cuahang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHangDomain ch = this.cuaHangRepository.findByMa(ma);
        this.cuaHangRepository.delete(ch);
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");
    }


    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        CuaHangDomain vm = new CuaHangDomain();

        try{
            BeanUtils.populate(vm,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        errorDiaChi = CheckString.checkValues(vm.getMa(),"địa chỉ");

        CuaHangDomain cv = cuaHangRepository.findByMa(vm.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/create");
            return;
        }

        this.cuaHangRepository.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");
    }

    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        CuaHangDomain vm = this.cuaHangRepository.findByMa(ma);
        try{
            BeanUtils.populate(vm,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        errorDiaChi = CheckString.checkValues(vm.getDiaChi(),"địa chỉ");

        if (!errorTen.isEmpty()||!errorMa.isEmpty()||!errorDiaChi.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/edit?ma="+vm.getMa());
            return;
        }
        this.cuaHangRepository.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/cuahang/index");
    }
}
