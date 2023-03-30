package controller;

import domain_model.ChucVuDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import java.io.IOException;

@WebServlet({
        "/chucvu/index", //GET
        "/chucvu/create", //GET
        "/chucvu/store", //POST
        "/chucvu/edit", //GET
        "/chucvu/update", //POST
        "/chucvu/delete", //GET
})
public class ChucVuServlet extends HttpServlet {
    ChucVuRepository chucVuRepository;
    public ChucVuServlet()
    {
        this.chucVuRepository = new ChucVuRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSChucVu", this.chucVuRepository.findAll());
        request.setAttribute("view", "/views/chucvu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chucvu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVuDomain chucVu = this.chucVuRepository.findByMa(ma);
        request.setAttribute("cv", chucVu);
        request.setAttribute("view", "/views/chucvu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVuDomain cv = this.chucVuRepository.findByMa(ma);
        this.chucVuRepository.delete(cv);
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");
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
        try {
            ChucVuDomain vm = new ChucVuDomain();
            BeanUtils.populate(vm, request.getParameterMap());
            this.chucVuRepository.insert(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            ChucVuDomain vm = this.chucVuRepository.findByMa(ma);
            BeanUtils.populate(vm, request.getParameterMap());
            this.chucVuRepository.update(vm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/chucvu/index");
    }
}