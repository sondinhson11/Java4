package controllers.admin;

import entity.MauSac;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import repositories.NhanVienRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet({"/nhanvien/index", "/nhanvien/create", "/nhanvien/store",
        "/nhanvien/edit", "/nhanvien/update", "/nhanvien/delete"})
public class NhanVienServlet extends HttpServlet {
    NhanVienRepository nhanVienRepo;
//    DateConverter converter = new DateConverter(null);

    @Override
    public void init() throws ServletException {
//        converter.setPattern("yyyy-MM-dd");
        nhanVienRepo = new NhanVienRepository();

        nhanVienRepo.insert(new NhanVien("NV1", "Lê", "Thị", "Hạnh", "Nữ",
                "28/7/2003", "Hà Nam", "0389478937", "123", 0));
        nhanVienRepo.insert(new NhanVien("NV2", "Đinh", "Tuấn", "Anh", "Nam",
                "28/7/2003", "Hoà Bình", "0389478937", "123", 0));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nhanvien/delete")) {
            delete(request, response);
        } else if (url.contains("/nhanvien/create")) {
            create(request, response);
        } else if (url.contains("/nhanvien/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/nhanvien/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", nhanVienRepo.getAll());
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        try {
            BeanUtils.populate(nhanVien, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        nhanVienRepo.insert(nhanVien);
        response.sendRedirect("/nhanvien/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        try {
            BeanUtils.populate(nhanVien, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(nhanVien);
        nhanVienRepo.update(nhanVien);
        response.sendRedirect("/nhanvien/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nhanVienRepo.getByMa(ma);
        request.setAttribute("nv", nv);
        request.setAttribute("navbar", "/layout/nhanvien.jsp");
        request.setAttribute("view", "/nhanvien/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nhanVienRepo.getByMa(ma);
        nhanVienRepo.delete(nv);
        try {
            response.sendRedirect("/nhanvien/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
