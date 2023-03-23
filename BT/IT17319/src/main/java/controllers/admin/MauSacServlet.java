package controllers.admin;

import entity.DongSP;
import entity.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/mausac/index", "/mausac/create", "/mausac/store",
        "/mausac/edit", "/mausac/update", "/mausac/delete"})
public class MauSacServlet extends HttpServlet {
    MauSacRepository mauSacRepo;

    String errorMa;
    String errorTen;
    String trungMa;
    @Override
    public void init() throws ServletException {
        mauSacRepo = new MauSacRepository();
        mauSacRepo.insert(new MauSac("1", "MS1", "Red"));
        mauSacRepo.insert(new MauSac("2", "MS2", "Yellow"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/mausac/delete")) {
            delete(request, response);
        } else if (url.contains("/mausac/create")) {
            create(request, response);
        } else if (url.contains("/mausac/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/mausac/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", mauSacRepo.getAll());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/mausac/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/mausac/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MauSac mauSac = new MauSac();
        try {
            BeanUtils.populate(mauSac, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        MauSac d = mauSacRepo.getByMa(mauSac.getMa());
        boolean check = false;
        if (d!=null){
            trungMa = "Trùng mã";
            check= true;
        }else{trungMa = "" ;  }
        errorMa = CheckString.checkValues(mauSac.getMa(),"mã");
        errorTen = CheckString.checkValues(mauSac.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/mausac/create");
            return;
        }
        mauSacRepo.insert(mauSac);
        response.sendRedirect("/mausac/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MauSac mauSac = new MauSac();
        try {
            BeanUtils.populate(mauSac, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean check =false;
        errorMa = CheckString.checkValues(mauSac.getMa(),"mã");
        errorTen = CheckString.checkValues(mauSac.getTen(),"tên");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()){
            check = true;
        }
        if (check){
            response.sendRedirect("/mausac/edit");
            return;
        }
        mauSacRepo.insert(mauSac);
        response.sendRedirect("/mausac/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = mauSacRepo.getByMa(ma);
        request.setAttribute("ms", ms);
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/mausac/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = mauSacRepo.getByMa(ma);
        mauSacRepo.delete(ms);
        try {
            response.sendRedirect("/mausac/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
