package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewmodel.QLNSX;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/index", //GET
        "/nsx/create", //GET
        "/nsx/store", //POST
        "/nsx/edit", //GET
        "/nsx/update", //POST
        "/nsx/delete", //GET
})
public class NSXServlet extends HttpServlet {
    ArrayList<QLNSX> list = new ArrayList<>();

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
        request.setAttribute("DSNSX",this.list);
        request.getRequestDispatcher("/views/nsx/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/edit.jsp").forward(request,response);
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
        QLNSX nsx = new QLNSX(ma,ten);
        list.add(nsx);
    }
}
