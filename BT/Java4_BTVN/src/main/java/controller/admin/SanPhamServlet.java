package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import ViewModel.SanPham;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/store",    // POST
        "/san-pham/edit",     // GET
        "/san-pham/update",   // POST
        "/san-pham/delete",   // GET
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sprp ;
    public SanPhamServlet(){
        sprp = new SanPhamRepository();
        this.sprp.insert(new SanPham("SP1", "Ao 3 lo "));
        this.sprp.insert(new SanPham("Sp2", "Ao 4 lo"));
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

        request.setAttribute("danhSach8", this.sprp.findALL());
        request.setAttribute("view","/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }


    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham qlnv = this.sprp.findMa(ma);

        if(qlnv == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.sprp.delete(qlnv);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/san-pham/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham qlnv = this.sprp.findMa(ma);
        request.setAttribute("sp",qlnv);
        request.setAttribute("view","/views/san_pham/edit.jsp");
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
            response.sendRedirect("/Java4_BTVN_war_exploded/san-pham/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, request.getParameterMap());
            this.sprp.insert(sp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/san-pham/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, request.getParameterMap());
            this.sprp.update(sp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/Java4_BTVN_war_exploded/san-pham/index");
    }
}