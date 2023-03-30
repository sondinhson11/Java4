package controller.admin;

import DomainModel.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/nsx/index",    // GET
        "/nsx/create",   // GET
        "/nsx/store",    // POST
        "/nsx/edit",     // GET
        "/nsx/update",   // POST
        "/nsx/delete",   // GET
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsx ;
    public NSXServlet(){
        nsx = new NSXRepository();
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

        request.setAttribute("danhSach7", this.nsx.findALL());
        request.setAttribute("view","/views/n_sx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/n_sx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX domainNSX = this.nsx.findByMa(ma);

        if(domainNSX == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.nsx.delete(domainNSX);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/nsx/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX domainNSX = this.nsx.findByMa(ma);
        request.setAttribute("nsx",domainNSX);
        request.setAttribute("view","/views/n_sx/edit.jsp");
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
            response.sendRedirect("/Java4_BTVN_war_exploded/nsx/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NSX domainNSX = new NSX();
        try {
            BeanUtils.populate(domainNSX, request.getParameterMap());
            this.nsx.insert(domainNSX);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/nsx/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX domainNSX = this.nsx.findByMa(ma);
        try {
            BeanUtils.populate(domainNSX, request.getParameterMap());
            this.nsx.update(domainNSX);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/nsx/index");
    }
}