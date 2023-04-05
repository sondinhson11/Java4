package controller;

import domain_model.ChucVuDomain;
import domain_model.CuaHangDomain;
import domain_model.NhanVienDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;
import viewmodel.QLNhanVien;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

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
    ChucVuRepository chucVuRepository;
    CuaHangRepository cuaHangRepository;
    String error ;
    String errorTen;
    String errorMa;

    public NhanVienServlet(){
        nhanVienRepository = new NhanVienRepository();
        chucVuRepository = new ChucVuRepository();
        cuaHangRepository = new CuaHangRepository();
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
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/nhanvien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        NhanVienDomain nv = this.nhanVienRepository.findByMa(ma);
        request.setAttribute("nv",nv);
        request.setAttribute("view", "/views/nhanvien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVienDomain nv = this.nhanVienRepository.findByMa(ma);
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
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        NhanVienDomain DomainModelNv = new NhanVienDomain();
        String maCv = request.getParameter("idCV");
        String maCh = request.getParameter("idCH");
        UUID idCV = UUID.fromString(maCv);
        UUID idCH = UUID.fromString(maCh);
        ChucVuDomain DomainModelCv = this.chucVuRepository.findById(idCV);
        CuaHangDomain DomainModelCh = this.cuaHangRepository.findById(idCH);

        DomainModelNv.setMa(nv.getMa());
        DomainModelNv.setTen(nv.getTen());
        DomainModelNv.setTenDem(nv.getTenDem());
        DomainModelNv.setHo(nv.getHo());
        DomainModelNv.setGioiTinh(nv.getGioiTinh());
        DomainModelNv.setNgaySinh(nv.getNgaySinh());
        DomainModelNv.setDiaChi(nv.getDiaChi());
        DomainModelNv.setSdt(nv.getSdt());
        DomainModelNv.setMatKhau(nv.getMatKhau());
        DomainModelNv.setCuaHang(DomainModelCh);
        DomainModelNv.setCv(DomainModelCv);
        DomainModelNv.setTrangThai(nv.getTrangThai());
        try {
            this.nhanVienRepository.insert(DomainModelNv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVienDomain nv = this.nhanVienRepository.findByMa(ma);
        try {
            BeanUtils.populate(nv,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maCv = request.getParameter("idCV");
        String maCh = request.getParameter("idCH");
        UUID idCV = UUID.fromString(maCv);
        UUID idCH = UUID.fromString(maCh);
        ChucVuDomain DomainModelCv = this.chucVuRepository.findById(idCV);
        CuaHangDomain DomainModelCh = this.cuaHangRepository.findById(idCH);
        nv.setCv(DomainModelCv);
        nv.setCuaHang(DomainModelCh);
        nhanVienRepository.update(nv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");
    }
}
