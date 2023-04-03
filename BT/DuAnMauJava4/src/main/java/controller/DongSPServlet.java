package controller;

import domain_model.DongSPDomain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.DongSPRepository;
import java.io.IOException;

@WebServlet(name = "DongSPServlet", value = {
        "/dongSP/index", //GET
        "/dongSP/create", //GET
        "/dongSP/store", //POST
        "/dongSP/edit", //GET
        "/dongSP/update", //POST
        "/dongSP/delete", //GET
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository;

    String error ;
    String errorTen;
    String errorMa;
    public DongSPServlet(){
        dongSPRepository = new DongSPRepository();
    }

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
        request.setAttribute("view", "/views/dongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/dongSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSPDomain qlDongSP = dongSPRepository.findByMa(ma);
        request.setAttribute("dsp",qlDongSP);
        request.setAttribute("view", "/views/dongSP/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSPDomain qlDongSP = dongSPRepository.findByMa(ma);
        dongSPRepository.delete(qlDongSP);
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");

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
            DongSPDomain vm = new DongSPDomain();
            BeanUtils.populate(vm,request.getParameterMap());
            this.dongSPRepository.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");
    }
    protected void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        try{
            String ma = request.getParameter("ma");
            DongSPDomain vm = this.dongSPRepository.findByMa(ma);
            BeanUtils.populate(vm,request.getParameterMap());
            this.dongSPRepository.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/DuAnMauJava4_war_exploded/dongSP/index");
    }
}
