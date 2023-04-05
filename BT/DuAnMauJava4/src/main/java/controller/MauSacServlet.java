package controller;

import domain_model.ChucVuDomain;
import domain_model.MauSacDomain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet(name = "MauSacServlet", value = {
        "/mausac/index", //GET
        "/mausac/create", //GET
        "/mausac/store", //POST
        "/mausac/edit", //GET
        "/mausac/update", //POST
        "/mausac/delete", //GET
})
public class MauSacServlet extends HttpServlet {
    MauSacRepository mauSacRepository;
    String error ;
    String errorTen;
    String errorMa;

    public MauSacServlet(){
        mauSacRepository = new MauSacRepository();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("DSMauSac",this.mauSacRepository.findAll());
        request.setAttribute("view", "/views/mausac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view", "/views/mausac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSacDomain ms = this.mauSacRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("ms", ms);
        request.setAttribute("view", "/views/mausac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSacDomain ms = this.mauSacRepository.findByMa(ma);
        this.mauSacRepository.delete(ms);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.index(request, response);
        }
    }
    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        MauSacDomain vm = new MauSacDomain();
        try{
            BeanUtils.populate(vm,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        MauSacDomain cv = mauSacRepository.findByMa(vm.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/create");
            return;
        }

        this.mauSacRepository.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");

    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        MauSacDomain mauSacDomain = this.mauSacRepository.findByMa(ma);
        try{
            BeanUtils.populate(mauSacDomain,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(mauSacDomain.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/edit?ma="+mauSacDomain.getMa());
            return;
        }
        this.mauSacRepository.update(mauSacDomain);
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");
    }
}
