package controller;


import domain_model.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.KhachHangRepository;
import view_model.QLKhachHang;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/edit",     // GET
        "/khach-hang/delete",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet{
    private KhachHangRepository khRepo;

    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if(uri.contains("create")) {
            this.create(request, response);
        }else if(uri.contains("edit")){
            this.edit(request, response);
        }else if(uri.contains("delete")){
            this.delete(request, response);
        }
        else{
            this.index(request, response);
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainmodelKH = this.khRepo.findByMa(ma);
        request.setAttribute("kh", domainmodelKH);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainmodelKH = this.khRepo.findByMa(ma);
        this.khRepo.delete(domainmodelKH);
        response.sendRedirect("/BTVN_war_exploded/khach-hang/index");
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhsachKH",this.khRepo.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/BTVN_war_exploded/khach-hang/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            KhachHang domainModelKH = new KhachHang();
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khRepo.insert(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/khach-hang/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            KhachHang domainModelKH = this.khRepo.findByMa(ma);
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khRepo.update(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/BTVN_war_exploded/khach-hang/index");
    }
}
