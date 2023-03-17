package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import viewmodel.QLMauSac;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = {
        "/mausac/index", //GET
        "/mausac/create", //GET
        "/mausac/store", //POST
        "/mausac/edit", //GET
        "/mausac/update", //POST
        "/mausac/delete", //GET
})
public class MauSacServlet extends HttpServlet {
    ArrayList<QLMauSac> list = new ArrayList<>();

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
        request.setAttribute("DSMauSac",this.list);
        request.getRequestDispatcher("/views/mausac/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mausac/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mausac/edit.jsp").forward(request,response);
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
        QLMauSac ms = new QLMauSac(ma,ten);
        list.add(ms);
    }
}
