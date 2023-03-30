package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repostory.nhanvienrepostory;
import view_model.QLNhanVien;
import java.io.IOException;


@WebServlet({
        "/nhan-vien/index", //GET
        "/nhan-vien/create", //GET
        "/nhan-vien/edit", //GET
        "/nhan-vien/delete", //GET
        "/nhan-vien/store", //POST
        "/nhan-vien/update", //POST

})
public class NhanVienServlet extends HttpServlet {
    private nhanvienrepostory nvrepo;
    public NhanVienServlet(){
        this.nvrepo = new nhanvienrepostory();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request,response);

        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else {
            this.index(request,response);
        }
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = this.nvrepo.findByMa(ma);
        this.nvrepo.delete(nv);
        response.sendRedirect("/KhachHang_war_exploded/nhan-vien/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = this.nvrepo.findByMa(ma);
        request.setAttribute("nv", nv);
        request.setAttribute("view","/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.litsKhachHang.add(new QLKhachHang("PH1", "Ng", "Van", "AA", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
//        this.litsKhachHang.add(new QLKhachHang("PH2", "Tran", "Van", "BB", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
        request.setAttribute("danhSachNV",this.nvrepo.findAll());
        request.setAttribute("view","/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else {
            response.sendRedirect("/KhachHang_war_exploded/nhan-vien/index");

        }    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien vm = new QLNhanVien();
            BeanUtils.populate(vm,request.getParameterMap());
            this.nvrepo.insert(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/nhan-vien/index");

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien vm = new QLNhanVien();
            BeanUtils.populate(vm,request.getParameterMap());
            this.nvrepo.update(vm);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/KhachHang_war_exploded/nhan-vien/index");

    }
}
