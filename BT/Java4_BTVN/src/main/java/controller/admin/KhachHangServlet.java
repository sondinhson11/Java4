package controller.admin;

import DomainModel.KhachHang;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/edit",     // GET
        "/khach-hang/update",   // POST
        "/khach-hang/delete",   // GET
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khrp ;
    public KhachHangServlet(){
        khrp = new KhachHangRepository();
    }


    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
             this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach", this.khrp.findALL());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String uri  =  request.getRequestURI();
       if(uri.contains("store")){
           this.store(request,response);
       }else if(uri.contains("update")){
           this.update(request,response);
       }else{
           response.sendRedirect("/Java4_BTVN_war_exploded/khach-hang/index");
       }

    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainKH = this.khrp.findByMa(ma);

        if(domainKH == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.khrp.delete(domainKH);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/khach-hang/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainKH = this.khrp.findByMa(ma);
        request.setAttribute("kh",domainKH);
        request.setAttribute("view", "/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHang domainKH = new KhachHang();
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.khrp.insert(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/khach-hang/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainKH = this.khrp.findByMa(ma);
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.khrp.update(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Java4_BTVN_war_exploded/khach-hang/index");
    }
}