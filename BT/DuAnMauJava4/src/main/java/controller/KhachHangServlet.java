package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.KhachHangRepository;
import viewmodel.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

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

    public KhachHangServlet()
    {
        this.khRepo = new KhachHangRepository();
        this.khRepo.insert(new QLKhachHang("PH1", "Ng", "Van", "AA", "123 tô hiệu", "0123123123", "123", "HN", "VN", "12/12/2021"));
        this.khRepo.insert(new QLKhachHang("PH2", "Tran", "Van", "BB", "435 Giảng võ", "0123123123", "123", "HN", "VN", "12/12/2021"));
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        }else{
            this.index(request,response);
        }

    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachKH",this.khRepo.findAll());
        request.getRequestDispatcher("/views/khachhang/index.jsp").forward(request, response);
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/create.jsp").forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = this.khRepo.findByMa(ma);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/views/khachhang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request, response);
        }else{
            this.index(request, response);
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String mat_khau = request.getParameter("mat_khau");
        String dia_chi = request.getParameter("dia_chi");
        String thanh_pho = request.getParameter("thanh_pho");
        String quoc_gia = request.getParameter("quoc_gia");
        String ngay_sinh = request.getParameter("ngay_sinh");

        QLKhachHang vm = new QLKhachHang(ma, ho, ten_dem, ten, dia_chi,  sdt, mat_khau, thanh_pho,quoc_gia,ngay_sinh);
        this.khRepo.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String mat_khau = request.getParameter("mat_khau");
        String dia_chi = request.getParameter("dia_chi");
        String thanh_pho = request.getParameter("thanh_pho");
        String quoc_gia = request.getParameter("quoc_gia");
        String ngay_sinh = request.getParameter("ngay_sinh");

        QLKhachHang vm = new QLKhachHang(ma, ho, ten_dem, ten, dia_chi,  sdt, mat_khau, thanh_pho,quoc_gia,ngay_sinh);
        this.khRepo.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");

    }
}
