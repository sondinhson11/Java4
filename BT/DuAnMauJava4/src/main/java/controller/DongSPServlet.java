package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.DongSPRepository;
import viewmodel.QLDongSP;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DongSPServlet", value = {
        "/dongSP/index", //GET
        "/dongSP/create", //GET
        "/dongSP/store", //POST
        "/dongSP/edit", //GET
        "/dongSP/update", //POST
        "/dongSP/delete", //GET
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);

        } else if (uri.contains("edit")) {
            this.edit(request,response);
        }else if (uri.contains("delete")){
            this.delete(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSDongSP",this.dongSPRepository.findAll());
        request.getRequestDispatcher("/views/dongSP/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dongSP/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP qlDongSP = dongSPRepository.findByMa(ma);
        request.setAttribute("dsp",qlDongSP);
        request.getRequestDispatcher("/views/dongSP/edit.jsp").forward(request,response);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP qlDongSP = dongSPRepository.findByMa(ma);
        dongSPRepository.delete(qlDongSP);
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);

        }else{
            this.update(request,response);
        }
    }
    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLDongSP dsp = new QLDongSP(ma,ten);
        this.dongSPRepository.insert(dsp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");
    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        QLDongSP dsp = new QLDongSP(ma,ten);
        this.dongSPRepository.update(dsp);
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");
    }
}
