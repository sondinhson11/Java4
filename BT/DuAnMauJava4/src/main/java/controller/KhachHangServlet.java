package controller;

import domain_model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.KhachHangRepository;
import utils.CheckString;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/khachhang/index", //GET
        "/khachhang/create", //GET
        "/khachhang/store", //POST
        "/khachhang/edit", //GET
        "/khachhang/update", //POST
        "/khachhang/delete", //GET
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;
    String error ;
    String errorMa;
    String errorHo;
    String errorTenDem;
    String errorTen;
    String errorNgaySinh;
    String errorSDT;
    String errorDiaChi;
    String errorMK;

    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
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
            this.edit(request, response);
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
        request.setAttribute("danhSachKH", this.khRepo.findAll());
        request.setAttribute("view", "/views/khachhang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("errorMa",errorMa);
        request.setAttribute("errorHo",errorHo);
        request.setAttribute("errorTenDem",errorTenDem);
        request.setAttribute("errorTen",errorTen);
        request.setAttribute("errorNgaySinh",errorNgaySinh);
        request.setAttribute("errorDiaChi",errorDiaChi);
        request.setAttribute("errorSDT",errorSDT);
        request.setAttribute("errorMK",errorMK);
        request.setAttribute("view", "/views/khachhang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHangDomain kh = this.khRepo.findByMa(ma);
        request.setAttribute("errorMa",errorMa);
        request.setAttribute("errorHo",errorHo);
        request.setAttribute("errorTenDem",errorTenDem);
        request.setAttribute("errorTen",errorTen);
        request.setAttribute("errorNgaySinh",errorNgaySinh);
        request.setAttribute("errorDiaChi",errorDiaChi);
        request.setAttribute("errorSDT",errorSDT);
        request.setAttribute("errorMK",errorMK);
        request.setAttribute("kh", kh);
        request.setAttribute("view", "/views/khachhang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHangDomain kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");
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

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHangDomain vm = new KhachHangDomain();
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        errorHo = CheckString.checkValues(vm.getHo(),"họ");
        errorTenDem = CheckString.checkValues(vm.getTenDem(),"tên đệm");
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorNgaySinh = CheckString.checkValues(String.valueOf(vm.getNgaySinh()),"ngày sinh");
        errorDiaChi = CheckString.checkValues(vm.getDiaChi(),"địa chỉ");
        errorSDT = CheckString.checkValues(vm.getSdt(),"sđt");
        errorMK = CheckString.checkValues(vm.getMatKhau(),"mật khẩu");

        KhachHangDomain cv = khRepo.findByMa(vm.getMa());

        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/create");
            return;
        }else{
            error="";
        }

        if (!errorMa.isEmpty()||!errorHo.isEmpty()||!errorTenDem.isEmpty()||!errorTen.isEmpty()||!errorNgaySinh.isEmpty()||!errorDiaChi.isEmpty()||!errorSDT.isEmpty()||!errorMK.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/create");
            return;
        }
        this.khRepo.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHangDomain vm = this.khRepo.findByMa(ma);
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorHo = CheckString.checkValues(vm.getHo(),"họ");
        errorTenDem = CheckString.checkValues(vm.getTenDem(),"tên đệm");
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorNgaySinh = CheckString.checkValues(String.valueOf(vm.getNgaySinh()),"ngày sinh");
        errorDiaChi = CheckString.checkValues(vm.getDiaChi(),"địa chỉ");
        errorSDT = CheckString.checkValues(vm.getSdt(),"sđt");
        errorMK = CheckString.checkValues(vm.getMatKhau(),"mật khẩu");

        if (!errorHo.isEmpty()||!errorTenDem.isEmpty()||!errorTen.isEmpty()||!errorNgaySinh.isEmpty()||!errorDiaChi.isEmpty()||!errorSDT.isEmpty()||!errorMK.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/edit?ma="+vm.getMa());
            return;
        }

        this.khRepo.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");
    }
}