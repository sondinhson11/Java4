package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "FPT!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name ="FPT POLYTECHNIC";
        request.setAttribute("hoTen",name);
        request.getRequestDispatcher("views/hello.jsp").forward(request,response);

    }

    public void destroy() {
    }
}