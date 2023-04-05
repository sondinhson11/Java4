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
import utils.CheckString;
import java.io.IOException;
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
    String errorMa;
    String errorHo;
    String errorTenDem;
    String errorTen;
    String errorNgaySinh;
    String errorDiaChi;
    String errorSDT;
    String errorMK;

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
        request.setAttribute("trungMa",error);
        request.setAttribute("DSNhanVien",this.nhanVienRepository.findAll());
        request.setAttribute("view", "/views/nhanvien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        request.setAttribute("trungMa",error);
        request.setAttribute("errorMa",errorMa);
        request.setAttribute("errorHo",errorHo);
        request.setAttribute("errorTenDem",errorTenDem);
        request.setAttribute("errorTen",errorTen);
        request.setAttribute("errorNgaySinh",errorNgaySinh);
        request.setAttribute("errorDiaChi",errorDiaChi);
        request.setAttribute("errorSDT",errorSDT);
        request.setAttribute("errorMK",errorMK);

        request.setAttribute("view", "/views/nhanvien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("dscv",this.chucVuRepository.findAll());
        request.setAttribute("dsch",this.cuaHangRepository.findAll());
        NhanVienDomain nv = this.nhanVienRepository.findByMa(ma);

        request.setAttribute("errorMa",errorMa);
        request.setAttribute("errorHo",errorHo);
        request.setAttribute("errorTenDem",errorTenDem);
        request.setAttribute("errorTen",errorTen);
        request.setAttribute("errorNgaySinh",errorNgaySinh);
        request.setAttribute("errorDiaChi",errorDiaChi);
        request.setAttribute("errorSDT",errorSDT);
        request.setAttribute("errorMK",errorMK);

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
        NhanVienDomain DomainModelNv = new NhanVienDomain();
        try {
            BeanUtils.populate(DomainModelNv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        errorMa = CheckString.checkValues(DomainModelNv.getMa(),"mã");
        errorHo = CheckString.checkValues(DomainModelNv.getHo(),"họ");
        errorTenDem = CheckString.checkValues(DomainModelNv.getTenDem(),"tên đệm");
        errorTen = CheckString.checkValues(DomainModelNv.getTen(),"tên");
        errorNgaySinh = CheckString.checkValues(String.valueOf(DomainModelNv.getNgaySinh()),"ngày sinh");
        errorDiaChi = CheckString.checkValues(DomainModelNv.getDiaChi(),"địa chỉ");
        errorSDT = CheckString.checkValues(DomainModelNv.getSdt(),"sđt");
        errorMK = CheckString.checkValues(DomainModelNv.getMatKhau(),"mật khẩu");

        NhanVienDomain cv = nhanVienRepository.findByMa(DomainModelNv.getMa());

        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/create");
            return;
        }else{
            error="";
        }

        if (!errorMa.isEmpty()||!errorHo.isEmpty()||!errorTenDem.isEmpty()||!errorTen.isEmpty()||!errorNgaySinh.isEmpty()||!errorDiaChi.isEmpty()||!errorSDT.isEmpty()||!errorMK.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/create");
            return;
        }

        String maCv = request.getParameter("idCV");
        String maCh = request.getParameter("idCH");
        UUID idCV = UUID.fromString(maCv);
        UUID idCH = UUID.fromString(maCh);
        ChucVuDomain DomainModelCv = this.chucVuRepository.findById(idCV);
        CuaHangDomain DomainModelCh = this.cuaHangRepository.findById(idCH);
        DomainModelNv.setCuaHang(DomainModelCh);
        DomainModelNv.setCv(DomainModelCv);

        this.nhanVienRepository.insert(DomainModelNv);
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


        errorMa = CheckString.checkValues(nv.getMa(),"mã");
        errorHo = CheckString.checkValues(nv.getHo(),"họ");
        errorTenDem = CheckString.checkValues(nv.getTenDem(),"tên đệm");
        errorTen = CheckString.checkValues(nv.getTen(),"tên");
        errorNgaySinh = CheckString.checkValues(String.valueOf(nv.getNgaySinh()),"ngày sinh");
        errorDiaChi = CheckString.checkValues(nv.getDiaChi(),"địa chỉ");
        errorSDT = CheckString.checkValues(nv.getSdt(),"sđt");
        errorMK = CheckString.checkValues(nv.getMatKhau(),"mật khẩu");

        NhanVienDomain cv = nhanVienRepository.findByMa(nv.getMa());

        if (!errorMa.isEmpty()||!errorHo.isEmpty()||!errorTenDem.isEmpty()||!errorTen.isEmpty()||!errorNgaySinh.isEmpty()||!errorDiaChi.isEmpty()||!errorSDT.isEmpty()||!errorMK.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/edit?ma="+nv.getMa());
            return;
        }

        String maCv = request.getParameter("idCV");
        String maCh = request.getParameter("idCH");
        UUID idCV = UUID.fromString(maCv);
        UUID idCH = UUID.fromString(maCh);
        ChucVuDomain DomainModelCv = this.chucVuRepository.findById(idCV);
        CuaHangDomain DomainModelCh = this.cuaHangRepository.findById(idCH);
        nv.setCuaHang(DomainModelCh);
        nv.setCv(DomainModelCv);


        nhanVienRepository.update(nv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nhanvien/index");
    }
}
