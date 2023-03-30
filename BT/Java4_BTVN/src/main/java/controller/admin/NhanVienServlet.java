package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NhanVienRepository;
import ViewModel.QLNhanVien;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/edit",     // GET
        "/nhan-vien/update",   // POST
        "/nhan-vien/delete",   // GET
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvrp ;
    public NhanVienServlet(){
            nvrp = new NhanVienRepository();
            this.nvrp.insert(new QLNhanVien("PH1", "Ng", "Van", "AAA", "12/12/2020", true, "123456", "1234", "1234", 1));
            this.nvrp.insert(new QLNhanVien("PH2", "Ng", "Van", "AAA", "12/12/2020", false, "123456", "1234", "1234", 1));

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
        request.setAttribute("danhSach6", this.nvrp.findALL());
        request.setAttribute("view","/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }



    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien qlnv = this.nvrp.findMa(ma);

        if(qlnv == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.nvrp.delete(qlnv);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien qlnv = this.nvrp.findMa(ma);
        request.setAttribute("nv",qlnv);
        request.setAttribute("view","/views/nhan_vien/edit.jsp");
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
            response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvrp.insert(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvrp.update(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
    }
}