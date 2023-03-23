package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.HoaDonRepository;
import viewmodel.QLHoaDon;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "HoaDonServlet", value = {
        "/hoadon/index", //GET
        "/hoadon/create", //GET
        "/hoadon/store", //POST
        "/hoadon/edit", //GET
        "/hoadon/update", //POST
        "/hoadon/delete", //GET
})
public class HoaDonServlet extends HttpServlet {
    HoaDonRepository hoaDonRepository;

    public HoaDonServlet() {
        hoaDonRepository = new HoaDonRepository();
//        this.hoaDonRepository.insert(new QLHoaDon("KH1","NV1", "HD1", Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), "Đạt 09", "Số 2 tô hiệu", "0123456789", 1));
//        this.hoaDonRepository.insert(new QLHoaDon("KH1","NV1", "HD1",Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), Date.valueOf("12-12-2003"), "Đạt 09", "Số 2 tô hiệu", "0123456789", 1));
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
        request.setAttribute("DSHoaDon", this.hoaDonRepository.findAll());
        request.setAttribute("view", "/views/hoadon/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/hoadon/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon sp = this.hoaDonRepository.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/hoadon/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon sp = this.hoaDonRepository.findByMa(ma);
        this.hoaDonRepository.delete(sp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadon/index");
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
            QLHoaDon vm = new QLHoaDon();
            BeanUtils.populate(vm, request.getParameterMap());
            this.hoaDonRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadon/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLHoaDon vm = new QLHoaDon();
            BeanUtils.populate(vm, request.getParameterMap());
            this.hoaDonRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/hoadon/index");
    }
}