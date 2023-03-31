package controller;

import domain_model.ChiTietSPDomain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.*;


import java.io.IOException;

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
        request.setAttribute("view", "/views/ctsanpham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("SLMS",this.chiTietSPRepository.findAll());
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
        request.setAttribute("sp", sp);
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
        try {
            ChiTietSPDomain vm = new ChiTietSPDomain();
            BeanUtils.populate(vm, request.getParameterMap());
            this.chiTietSPRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChiTietSPDomain vm = this.chiTietSPRepository.findByMa(ma);
            BeanUtils.populate(vm, request.getParameterMap());
            this.chiTietSPRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
    }
}