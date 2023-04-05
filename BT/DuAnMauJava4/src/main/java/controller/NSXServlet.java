package controller;

import domain_model.ChucVuDomain;
import domain_model.NSXDomain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.NsxRepository;
import utils.CheckString;

import java.io.IOException;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/index", //GET
        "/nsx/create", //GET
        "/nsx/store", //POST
        "/nsx/edit", //GET
        "/nsx/update", //POST
        "/nsx/delete", //GET
})
public class NSXServlet extends HttpServlet {
    NsxRepository nsxRepository ;
    String error ;
    String errorTen;
    String errorMa;
    public NSXServlet(){
        nsxRepository = new NsxRepository();
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
        request.setAttribute("DSNSX",this.nsxRepository.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view", "/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("checkten", errorTen);
        NSXDomain nsx = this.nsxRepository.findByMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view", "/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSXDomain nsx = this.nsxRepository.findByMa(ma);
        this.nsxRepository.delete(nsx);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
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
        NSXDomain vm = new NSXDomain();
        try{
            BeanUtils.populate(vm,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        errorMa = CheckString.checkValues(vm.getMa(),"mã");
        NSXDomain cv = nsxRepository.findByMa(vm.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/create");
            return;
        }
        this.nsxRepository.insert(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        NSXDomain vm = this.nsxRepository.findByMa(ma);
        try{
            BeanUtils.populate(vm,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(vm.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/edit?ma="+vm.getMa());
            return;
        }
        this.nsxRepository.update(vm);
        response.sendRedirect("/DuAnMauJava4_war_exploded/nsx/index");
    }
}
