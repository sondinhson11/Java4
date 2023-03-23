package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.MauSacRepository;
import viewmodel.QLChiTietSP;
import viewmodel.QLMauSac;

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


    public  ChiTietSPServlet() {
        chiTietSPRepository = new ChiTietSPRepository();
        mauSacRepository = new MauSacRepository();
        this.chiTietSPRepository.insert(new QLChiTietSP("CTSP1","SP1", "NSX1", "MS1", "DSP1", "2","Hàng Rất Đẹp",100, 500, 1000));
        this.chiTietSPRepository.insert(new QLChiTietSP("CTSP2","SP2", "NSX2", "MS2", "DSP2", "1","Hàng Rất Đẹp",100, 500, 1000));
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
        request.setAttribute("view", "/views/ctsanpham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSP sp = this.chiTietSPRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/ctsanpham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSP sp = this.chiTietSPRepository.findByMa(ma);
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
            QLChiTietSP vm = new QLChiTietSP();
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
            QLChiTietSP vm = new QLChiTietSP();
            BeanUtils.populate(vm, request.getParameterMap());
            this.chiTietSPRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/ctsanpham/index");
    }
}