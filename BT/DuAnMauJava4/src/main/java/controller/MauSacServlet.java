package controller;

import domain_model.MauSacDomain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;

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
        request.setAttribute("DSMauSac",this.mauSacRepository.findAll());
        request.setAttribute("view", "/views/mausac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/mausac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSacDomain ms = this.mauSacRepository.findByMa(ma);
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
        try{
            MauSacDomain vm = new MauSacDomain();
            BeanUtils.populate(vm,request.getParameterMap());
            this.mauSacRepository.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");

    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String ma = request.getParameter("ma");
            MauSacDomain mauSacDomain = this.mauSacRepository.findByMa(ma);
            BeanUtils.populate(mauSacDomain,request.getParameterMap());
            this.mauSacRepository.update(mauSacDomain);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/mausac/index");
    }
}
