package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import viewmodel.QLChucVu;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chucvu/index", //GET
        "/chucvu/create", //GET
        "/chucvu/store", //POST
        "/chucvu/edit", //GET
        "/chucvu/update", //POST
        "/chucvu/delete", //GET
})
public class ChucVuServlet extends HttpServlet {
    ArrayList<QLChucVu> list = new ArrayList<>();

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
        request.setAttribute("DSChucVu",this.list);
        request.getRequestDispatcher("/views/chucvu/index.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chucvu/create.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chucvu/edit.jsp").forward(request,response);
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
        QLChucVu cv = new QLChucVu(ma,ten);
        list.add(cv);
    }
}
