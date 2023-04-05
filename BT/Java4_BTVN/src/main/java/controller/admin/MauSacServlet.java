package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import DomainModel.MauSac;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;



@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/edit",     // GET
        "/mau-sac/update",   // POST
        "/mau-sac/delete",   // GET
})
public class MauSacServlet extends HttpServlet {
   private MauSacRepository mauSacRepository ;
   public MauSacServlet(){
       mauSacRepository= new MauSacRepository() ;
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
            response.sendRedirect("/Java4_BTVN_war_exploded/mau-sac/index");
        }
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach5",this.mauSacRepository.findALL());
        request.setAttribute("view","/views/mausac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/mausac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac cvs = this.mauSacRepository.findByMa(ma);

        if(cvs == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.mauSacRepository.delete(cvs);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/mau-sac/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac domainMS = this.mauSacRepository.findByMa(ma);
        request.setAttribute("ms",domainMS);
        request.setAttribute("view","/views/mausac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        MauSac domainMS = new MauSac();
            try {
                BeanUtils.populate(domainMS, request.getParameterMap());
                this.mauSacRepository.insert(domainMS);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/Java4_BTVN_war_exploded/mau-sac/index");

    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("ma");
       MauSac domainMS = this.mauSacRepository.findByMa(ma);
        try {
            BeanUtils.populate(domainMS,request.getParameterMap());
            this.mauSacRepository.update(domainMS);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/mau-sac/index");
    }
}