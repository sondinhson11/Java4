package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.GioHangRepository;
import viewmodel.QLGioHang;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "GioHangServlet", value = {
        "/giohang/index", //GET
        "/giohang/create", //GET
        "/giohang/store", //POST
        "/giohang/edit", //GET
        "/giohang/update", //POST
        "/giohang/delete", //GET
})
public class GioHangServlet extends HttpServlet {
    GioHangRepository gioHangRepository;
    String error ;
    String errorTen;
    String errorMa;
    public GioHangServlet() {
        gioHangRepository = new GioHangRepository();
        this.gioHangRepository.insert(new QLGioHang("KH1", "NV1", "GH1", Date.valueOf("2023/03/23"), Date.valueOf("2023/03/23"), "Nguyện", "Tuyên Quang", "01234567789", 1));
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
        request.setAttribute("DSGGH", this.gioHangRepository.findAll());
        request.setAttribute("view", "/views/giohang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/giohang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLGioHang sp = this.gioHangRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/giohang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLGioHang sp = this.gioHangRepository.findByMa(ma);
        this.gioHangRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohang/index");
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
            QLGioHang vm = new QLGioHang();
            BeanUtils.populate(vm, request.getParameterMap());
            this.gioHangRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLGioHang vm = new QLGioHang();
            BeanUtils.populate(vm, request.getParameterMap());
            this.gioHangRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/giohang/index");
    }
}