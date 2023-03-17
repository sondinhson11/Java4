package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    ArrayList<QLDongSP> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")){
            edit(request,response);
        }else if (uri.contains("create")){
            this.create(request,response);
        }else{
            this.index(request,response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("DSDongSP",this.list);
        request.getRequestDispatcher("/views/dongSP/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dongSP/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dongSP/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.store(request,response);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        System.out.println(ma);
        System.out.println(ten);
        QLDongSP dsp = new QLDongSP(ma,ten);
        list.add(dsp);
    }
}
