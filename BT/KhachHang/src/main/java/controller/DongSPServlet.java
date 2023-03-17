package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.DongSPRepository;
import view_model.QLChucVu;
import view_model.QLDongSP;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/dong-sp/index", //GET
        "/dong-sp/create", //GET
        "/dong-sp/edit", //GET
        "/dong-sp/delete", //GET
        "/dong-sp/store", //POST
        "/dong-sp/update", //POST
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository;

    public DongSPServlet(){
        dongSPRepository = new DongSPRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);

        } else if (uri.contains("edit")) {
            edit(request,response);
        }else if (uri.contains("delete")){
            delete(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dong_sp/create.jsp").forward(request,response);

    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP qlDongSP = dongSPRepository.findByMa(ma);
        request.setAttribute("qlDongSP",qlDongSP);
        request.getRequestDispatcher("/views/dong_sp/edit.jsp").forward(request,response);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP qlDongSP = dongSPRepository.findByMa(ma);
        dongSPRepository.delete(qlDongSP);
        response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");

    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("danhSachDongSP",this.dongSPRepository.findAll());
        request.getRequestDispatcher("/views/dong_sp/index.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        store(request,response);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLDongSP qlDong = new QLDongSP(ma,ten);
        dongSPRepository.insert(qlDong);
        response.sendRedirect("/KhachHang_war_exploded/dong-sp/index");
    }
}
