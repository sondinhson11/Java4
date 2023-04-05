package controller.admin;

import DomainModel.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSpRepository;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dong-sp/index",    // GET
        "/dong-sp/create",   // GET
        "/dong-sp/store",    // POST
        "/dong-sp/edit",     // GET
        "/dong-sp/update",   // POST
        "/dong-sp/delete",   // GET
})
public class DongSPServlet extends HttpServlet {
    private DongSpRepository dsp;
   public DongSPServlet(){
       dsp = new DongSpRepository();

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

        request.setAttribute("danhSach4", this.dsp.findALL());
        request.setAttribute("view","/views/dong_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/dong_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP domainDSP = this.dsp.findByMa(ma);

        if(domainDSP == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.dsp.delete(domainDSP);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/dong-sp/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP ds = this.dsp.findByMa(ma);
        request.setAttribute("dsp",ds);
        request.setAttribute("view","/views/dong_sp/edit.jsp");
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
            response.sendRedirect("/Java4_BTVN_war_exploded/dong-sp/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        DongSP dsps = new DongSP();
        try {
            BeanUtils.populate(dsps, request.getParameterMap());
            this.dsp.insert(dsps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Java4_BTVN_war_exploded/dong-sp/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP domainDSP = this.dsp.findByMa(ma);
        try {
            BeanUtils.populate(domainDSP, request.getParameterMap());
            this.dsp.update(domainDSP);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/Java4_BTVN_war_exploded/dong-sp/index");
    }
}