package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.KhachHangRepository;
import view_model.QLKhachHang;

import java.io.IOException;

@WebServlet({
        "/khach-hang/index", //GET
        "/khach-hang/create", //GET
        "/khach-hang/edit", //GET
        "/khach-hang/delete", //GET
        "/khach-hang/store", //POST
        "/khach-hang/update", //POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khrp;

    public KhachHangServlet() {
        this.khrp = new KhachHangRepository();
//        this.khrp.insert(new QLKhachHang("PH1", "Ng", "Van", "AA", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
//        this.khrp.insert(new QLKhachHang("PH2", "Tran", "Van", "BB", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.creat(request,response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else {
            this.index(request,response);
        }
    }
    protected void creat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp").forward(request,response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        request.setAttribute("danhSachKH",this.khrp.findAll());
        request.getRequestDispatcher("/views/khach_hang/index.jsp").forward(request,response);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang  qlKhachHang = this.khrp.findByMa(ma);
        this.khrp.delete(qlKhachHang);
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
        }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang  qlKhachHang = this.khrp.findByMa(ma);
        request.setAttribute("kh",qlKhachHang);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            update(request,response);
        }else{
            index(request,response);
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho =request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        QLKhachHang qlKhachHang = new QLKhachHang(ma, ten,tenDem,ho,ngaySinh,sdt,diaChi,thanhPho,quocGia,matKhau);
        khrp.insert(qlKhachHang);
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho =request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        QLKhachHang qlKhachHang = new QLKhachHang(ma, ten,tenDem,ho,ngaySinh,sdt,diaChi,thanhPho,quocGia,matKhau);
        khrp.update(qlKhachHang);
        response.sendRedirect("/KhachHang_war_exploded/khach-hang/index");
    }
}
