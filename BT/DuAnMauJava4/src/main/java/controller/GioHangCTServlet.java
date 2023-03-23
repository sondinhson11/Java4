package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.GioHangCTRepository;
import viewmodel.QLGioHangChiTiet;

import java.io.IOException;

@WebServlet(name = "GioHangCTServlet", value = {
        "/giohangct/index", //GET
        "/giohangct/create", //GET
        "/giohangct/store", //POST
        "/giohangct/edit", //GET
        "/giohangct/update", //POST
        "/giohangct/delete", //GET
})
public class GioHangCTServlet extends HttpServlet {
    GioHangCTRepository gioHangCTRepository;

    public GioHangCTServlet() {
        gioHangCTRepository = new GioHangCTRepository();
        this.gioHangCTRepository.insert(new QLGioHangChiTiet("HD1", "CTSP1", 1, 200));
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
        request.setAttribute("DSGGHCT", this.gioHangCTRepository.findAll());
        request.setAttribute("view", "/views/giohangct/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/giohangct/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLGioHangChiTiet sp = this.gioHangCTRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/giohangct/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLGioHangChiTiet sp = this.gioHangCTRepository.findByMa(ma);
        this.gioHangCTRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohangct/index");
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
            QLGioHangChiTiet vm = new QLGioHangChiTiet("HD1", "CTSP1", 1, 200);
            BeanUtils.populate(vm, request.getParameterMap());
            this.gioHangCTRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohangct/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLGioHangChiTiet vm = new QLGioHangChiTiet("HD1", "CTSP1", 1, 200);
            BeanUtils.populate(vm, request.getParameterMap());
            this.gioHangCTRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohangct/index");
    }
}