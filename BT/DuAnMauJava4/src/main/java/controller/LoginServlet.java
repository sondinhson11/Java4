package controller;

import domain_model.NhanVienDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NhanVienRepository;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")

public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo = new NhanVienRepository();
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("view", "/views/login.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVienDomain nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("/DuAnMauJava4_war_exploded/login");
        } else {
            session.setAttribute("nv", nv);
            response.sendRedirect("/DuAnMauJava4_war_exploded/khachhang/index");
        }
    }
}
