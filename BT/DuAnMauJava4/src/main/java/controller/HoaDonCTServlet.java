package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.HoaDonCTRepository;
import viewmodel.QLHoaDonChiTiet;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "HoaDonCTServlet", value = {
        "/hoadonct/index", //GET
        "/hoadonct/create", //GET
        "/hoadonct/store", //POST
        "/hoadonct/edit", //GET
        "/hoadonct/update", //POST
        "/hoadonct/delete", //GET
})
public class HoaDonCTServlet extends HttpServlet {
    HoaDonCTRepository hoaDonCTRepository;

    public HoaDonCTServlet() {
        hoaDonCTRepository = new HoaDonCTRepository();
        this.hoaDonCTRepository.insert(new QLHoaDonChiTiet("HD1", "CTSP1", 10, 20));
        this.hoaDonCTRepository.insert(new QLHoaDonChiTiet("HD2", "CTSP2", 10, 20));
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
        request.setAttribute("DSHoaDonCT", this.hoaDonCTRepository.findAll());
        request.setAttribute("view", "/views/hoadonct/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/hoadonct/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDonChiTiet sp = this.hoaDonCTRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/hoadonct/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDonChiTiet sp = this.hoaDonCTRepository.findByMa(ma);
        this.hoaDonCTRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadonct/index");
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
            QLHoaDonChiTiet vm = new QLHoaDonChiTiet();
            BeanUtils.populate(vm, request.getParameterMap());
            this.hoaDonCTRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadonct/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLHoaDonChiTiet vm = new QLHoaDonChiTiet();
            BeanUtils.populate(vm, request.getParameterMap());
            this.hoaDonCTRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadonct/index");
    }
}