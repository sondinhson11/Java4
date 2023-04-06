package controller;

import domain_model.ChucVuDomain;
import domain_model.SanPhamDomain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.SanPhamRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet(name = "SanPhamServlet", value = {
        "/sanpham/index", //GET
        "/sanpham/create", //GET
        "/sanpham/store", //POST
        "/sanpham/edit", //GET
        "/sanpham/update", //POST
        "/sanpham/delete", //GET
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository;
    String error ;
    String errorTen;
    String errorMa;

    public SanPhamServlet() {
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("DSSanPham", this.sanPhamRepository.findAll());
        request.setAttribute("view", "/views/sanpham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/sanpham/create.jsp");
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkten", errorTen);
        String ma = request.getParameter("ma");
        SanPhamDomain sp = this.sanPhamRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/sanpham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPhamDomain sp = this.sanPhamRepository.findByMa(ma);
        this.sanPhamRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/index");
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

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        SanPhamDomain vm = new SanPhamDomain();
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        SanPhamDomain cv = sanPhamRepository.findByMa(vm.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/create");
            return;
        }
        this.sanPhamRepository.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPhamDomain vm = this.sanPhamRepository.findByMa(ma);
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/edit?ma="+vm.getMa());
            return;
        }
        this.sanPhamRepository.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/sanpham/index");
    }
}