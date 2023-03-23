package controllers.admin;

import entity.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/nsx/index", "/nsx/create", "/nsx/store",
        "/nsx/edit", "/nsx/update", "/nsx/delete"})
public class NSXServlet extends HttpServlet{

    String errorMa;
    String errorTen;
    String trungMa;
    NSXRepository nsxRepo;

    @Override
    public void init() throws ServletException {
        nsxRepo = new NSXRepository();
        nsxRepo.insert(new NSX("1", "NSX1", "Nhà Sản Xuất 1"));
        nsxRepo.insert(new NSX("2", "NSX2", "Nhà Sản Xuất 2"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nsx/delete")) {
            delete(request, response);
        } else if (url.contains("/nsx/create")) {
            create(request, response);
        } else if (url.contains("/nsx/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nsx/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", nsxRepo.getAll());
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/nsx/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/nsx/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NSX nsx = new NSX();
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//
        NSX d = nsxRepo.getByMa(nsx.getMa());
        boolean check = false;
        if (d!=null){
            trungMa = "Trùng mã";
            check= true;
        }else{
            trungMa  = "";
        }
        errorMa = CheckString.checkValues(nsx.getMa(),"mã");
        errorTen = CheckString.checkValues(nsx.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/nsx/create");
            return;
        }
//
        nsxRepo.insert(nsx);
        response.sendRedirect("/nsx/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NSX nsx = new NSX();
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean check  =false;
        errorMa = CheckString.checkValues(nsx.getMa(),"mã");
        errorTen = CheckString.checkValues(nsx.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/nsx/create");
            return;
        }
        nsxRepo.update(nsx);
        response.sendRedirect("/nsx/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = nsxRepo.getByMa(ma);
        request.setAttribute("nsx",nsx);
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/nsx/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = nsxRepo.getByMa(ma);
        nsxRepo.delete(nsx);
        response.sendRedirect("/nsx/index");
    }
}
