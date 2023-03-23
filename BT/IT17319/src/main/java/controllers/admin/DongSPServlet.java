package controllers.admin;

import entity.CuaHang;
import entity.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dongsp/index","/dongsp/create","/dongsp/store",
        "/dongsp/edit","/dongsp/update","/dongsp/delete"})
public class DongSPServlet extends HttpServlet {
    DongSPRepository dongSPRepo;
    String errorMa;
    String errorTen;
    String trungMa;

    @Override
    public void init() throws ServletException {
        dongSPRepo = new DongSPRepository();
        dongSPRepo.insert(new DongSP("1","DongSP1","Bánh"));
        dongSPRepo.insert(new DongSP("2","DongSP2","Kẹo"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/dongsp/delete")) {
            delete(request,response);
        }else if (url.contains("/dongsp/create")) {
            create(request,response);
        }else if(url.contains("/dongsp/edit")){
            edit(request,response);
        }else{
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/dongsp/store")){
            store(request, response);
        }else{
            update(request, response);
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list",dongSPRepo.getAll());
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/dongsp/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("view","/dongsp/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DongSP dongSP = new DongSP();
        try {
            BeanUtils.populate(dongSP, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        DongSP d = dongSPRepo.getByMa(dongSP.getMa());
        boolean check = false;
        if (d!=null){
            trungMa = "Trùng mã";
            check= true;
        }else{trungMa = "";   }
        errorMa = CheckString.checkValues(dongSP.getMa(),"mã");
        errorTen = CheckString.checkValues(dongSP.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/dongsp/create");
            return;
        }
        dongSPRepo.insert(dongSP);
        response.sendRedirect("/dongsp/index");
    }
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DongSP dongSP = new DongSP();
        try {
            BeanUtils.populate(dongSP, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean check = false;
        errorMa = CheckString.checkValues(dongSP.getMa(),"mã");
        errorTen = CheckString.checkValues(dongSP.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/dongsp/create");
            return;
        }
        dongSPRepo.update(dongSP);
        response.sendRedirect("/dongsp/index");
    }
    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dongSP = dongSPRepo.getByMa(ma);
        request.setAttribute("dongsp",dongSP);
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar","/layout/sanpham.jsp");
        request.setAttribute("view","/dongsp/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        DongSP dongSP = dongSPRepo.getByMa(ma);
        dongSPRepo.delete(dongSP);
        try {
            response.sendRedirect("/dongsp/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
