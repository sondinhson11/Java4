package controllers.admin;

import entity.NSX;
import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/sanpham/index","/sanpham/create","/sanpham/store",
        "/sanpham/edit","/sanpham/update","/sanpham/delete"})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepo;
    String errorMa;
    String errorTen;
    String trungMa;
    @Override
    public void init() throws ServletException {
        sanPhamRepo = new SanPhamRepository();
        sanPhamRepo.insert(new SanPham("1","SP1","Sản Phẩm 1"));
        sanPhamRepo.insert(new SanPham("2","SP2","Sản Phẩm 2"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/sanpham/delete")) {
            delete(request,response);
        }else if (url.contains("/sanpham/create")) {
            create(request,response);
        }else if(url.contains("/sanpham/edit")){
            edit(request,response);
        }else{
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/sanpham/store")){
            store(request, response);
        }else{
            update(request, response);
        }

    }
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list",sanPhamRepo.getAll());
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean check =false;
        SanPham d = sanPhamRepo.getByMa(sp.getMa());
        if (d!=null){
            trungMa = "Trùng mã";
            check= true;
        }else{trungMa = "" ;  }
        errorMa = CheckString.checkValues(sp.getMa(),"mã");
        errorTen = CheckString.checkValues(sp.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/sanpham/create");
            return;
        }
        sanPhamRepo.insert(sp);
        response.sendRedirect("/sanpham/index");
    }
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean check = false;
        errorMa = CheckString.checkValues(sp.getMa(),"mã");
        errorTen = CheckString.checkValues(sp.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/sanpham/create");
            return;
        }
        sanPhamRepo.update(sp);
        response.sendRedirect("/sanpham/index");
    }
    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sanPham = sanPhamRepo.getByMa(ma);
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("sp",sanPham);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/sanpham/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sanPham = sanPhamRepo.getByMa(ma);
        sanPhamRepo.delete(sanPham);
        response.sendRedirect("/sanpham/index");
    }
}
