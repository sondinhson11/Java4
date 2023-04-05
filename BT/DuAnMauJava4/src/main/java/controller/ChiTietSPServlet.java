package controller;

import domain_model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.*;
import utils.CheckString;
import viewmodel.QLChiTietSP;


import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/ctsanpham/index", //GET
        "/ctsanpham/create", //GET
        "/ctsanpham/store", //POST
        "/ctsanpham/edit", //GET
        "/ctsanpham/update", //POST
        "/ctsanpham/delete", //GET
})
public class ChiTietSPServlet extends HttpServlet {
    ChiTietSPRepository chiTietSPRepository;
    MauSacRepository mauSacRepository;
    SanPhamRepository sanPhamRepository;
    NsxRepository nsxRepository;
    DongSPRepository dongSPRepository;

    String errorNamBH;
    String errorMoTa;
    String errorSoLuongTon;
    String errorGiaNhap;
    String errorGiaBan;

    public  ChiTietSPServlet() {
        chiTietSPRepository = new ChiTietSPRepository();
        mauSacRepository = new MauSacRepository();
        sanPhamRepository = new SanPhamRepository();
        nsxRepository = new NsxRepository();
        dongSPRepository = new DongSPRepository();
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
        request.setAttribute("DSCTSP",this.chiTietSPRepository.findAll());
        request.setAttribute("view", "/views/ctsanpham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorNamBH", errorNamBH);
        request.setAttribute("errorMoTa", errorMoTa);
        request.setAttribute("errorSoLuongTon", errorSoLuongTon);
        request.setAttribute("errorGiaNhap", errorGiaNhap);
        request.setAttribute("errorGiaBan", errorGiaBan);

        request.setAttribute("dsms",this.mauSacRepository.findAll());
        request.setAttribute("dssp",this.sanPhamRepository.findAll());
        request.setAttribute("dsnxs",this.nsxRepository.findAll());
        request.setAttribute("dsdsp",this.dongSPRepository.findAll());
        request.setAttribute("view", "/views/ctsanpham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSPDomain sp = this.chiTietSPRepository.findByMa(ma);
        request.setAttribute("dsms",this.mauSacRepository.findAll());
        request.setAttribute("dssp",this.sanPhamRepository.findAll());
        request.setAttribute("dsnxs",this.nsxRepository.findAll());
        request.setAttribute("dsdsp",this.dongSPRepository.findAll());

        request.setAttribute("errorNamBH", errorNamBH);
        request.setAttribute("errorMoTa", errorMoTa);
        request.setAttribute("errorSoLuongTon", errorSoLuongTon);
        request.setAttribute("errorGiaNhap", errorGiaNhap);
        request.setAttribute("errorGiaBan", errorGiaBan);

        request.setAttribute("kh", sp);
        request.setAttribute("view", "/views/ctsanpham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSPDomain sp = this.chiTietSPRepository.findByMa(ma);
        this.chiTietSPRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
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
        ChiTietSPDomain chiTietSPDomain = new ChiTietSPDomain();
        try {
            BeanUtils.populate(chiTietSPDomain, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSP = request.getParameter("idSP");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");
        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP2 = UUID.fromString(idSP);
        UUID idNsx2 = UUID.fromString(idNsx);
        UUID idDongSP2 = UUID.fromString(idDongSP);
        MauSacDomain DomainModelMs = this.mauSacRepository.findById(idMS);
        SanPhamDomain DomainModelSP = this.sanPhamRepository.findById(idSP2);
        NSXDomain DomainModelNSx = this.nsxRepository.findById(idNsx2);
        DongSPDomain DomainModelDSp = this.dongSPRepository.findById(idDongSP2);
        chiTietSPDomain.setMs(DomainModelMs);
        chiTietSPDomain.setSp(DomainModelSP);
        chiTietSPDomain.setNsx(DomainModelNSx);
        chiTietSPDomain.setDsp(DomainModelDSp);

        errorNamBH = CheckString.checkValues(chiTietSPDomain.getNamBH(),"Năm Bảo Hành");
        errorMoTa = CheckString.checkValues(chiTietSPDomain.getMoTa(),"Mô Tả");
        errorSoLuongTon = CheckString.checkValues(chiTietSPDomain.getMoTa(),"Số Lượng Tồn");
        errorGiaNhap = CheckString.checkValues(chiTietSPDomain.getMoTa(),"Giá Nhập");
        errorGiaBan = CheckString.checkValues(chiTietSPDomain.getMoTa(),"Giá Bán");

        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/create");
            return;
        }

        this.chiTietSPRepository.insert(chiTietSPDomain);
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSPDomain vm = this.chiTietSPRepository.findByMa(ma);
        try {
            BeanUtils.populate(vm, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSP = request.getParameter("idSP");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");
        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP2 = UUID.fromString(idSP);
        UUID idNsx2 = UUID.fromString(idNsx);
        UUID idDongSP2 = UUID.fromString(idDongSP);
        MauSacDomain DomainModelMs = this.mauSacRepository.findById(idMS);
        SanPhamDomain DomainModelSP = this.sanPhamRepository.findById(idSP2);
        NSXDomain DomainModelNSx = this.nsxRepository.findById(idNsx2);
        DongSPDomain DomainModelDSp = this.dongSPRepository.findById(idDongSP2);
        vm.setMs(DomainModelMs);
        vm.setSp(DomainModelSP);
        vm.setNsx(DomainModelNSx);
        vm.setDsp(DomainModelDSp);

        errorNamBH = CheckString.checkValues(vm.getNamBH(),"Năm Bảo Hành");
        errorMoTa = CheckString.checkValues(vm.getMoTa(),"Mô Tả");
        errorSoLuongTon = CheckString.checkValues(vm.getMoTa(),"Số Lượng Tồn");
        errorGiaNhap = CheckString.checkValues(vm.getMoTa(),"Giá Nhập");
        errorGiaBan = CheckString.checkValues(vm.getMoTa(),"Giá Bán");

        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/edit?ma="+vm.getId());
            return;
        }

        this.chiTietSPRepository.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
    }
}