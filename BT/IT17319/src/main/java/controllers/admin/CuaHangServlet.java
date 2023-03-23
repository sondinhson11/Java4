package controllers.admin;

import entity.ChucVu;
import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;
import utils.CheckString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/cuahang/index", "/cuahang/create", "/cuahang/store",
        "/cuahang/edit", "/cuahang/update", "/cuahang/delete"})
public class CuaHangServlet extends HttpServlet {
    CuaHangRepository cuaHangRepo;

    String errorMa;
    String trungMa;
    String errorTen;
    String errorDiaChi;
    @Override
    public void init() throws ServletException {
        cuaHangRepo = new CuaHangRepository();
        cuaHangRepo.insert(new CuaHang("1", "CH1", "Cửa hàng 1", "Nam từ liêm",
                "Hà Nội", "Việt Nam"));
        cuaHangRepo.insert(new CuaHang("2", "CH2", "Cửa hàng 2", "Bắc từ liêm",
                "Tokyo", "Nhật Bản"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/cuahang/delete")) {
            delete(request, response);
        } else if (url.contains("/cuahang/create")) {
            create(request, response);
        } else if (url.contains("/cuahang/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/cuahang/store")) {
            store(request, response);
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", cuaHangRepo.getAll());
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/cuahang/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("errorma",errorMa);
        request.setAttribute("trungma",trungMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("errordiachi",errorDiaChi);
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/cuahang/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CuaHang cuaHang = new CuaHang();
        try {
            BeanUtils.populate(cuaHang, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CuaHang ch = cuaHangRepo.getByMa(cuaHang.getMa());
        boolean check = false;
        if (ch!=null){
            trungMa = "Trùng mã";
            check = true;
        }else{
            trungMa ="";
        }
        if (check){
            response.sendRedirect("/cuahang/create");
            return;
        }
        errorMa = CheckString.checkValues(cuaHang.getMa(),"mã");
        errorTen = CheckString.checkValues(cuaHang.getTen(),"tên");
        errorDiaChi = CheckString.checkValues(cuaHang.getDiaChi(),"địa chỉ");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()||!errorDiaChi.isEmpty()){
            response.sendRedirect("/cuahang/create");
            return;
        }
        cuaHangRepo.insert(cuaHang);
        response.sendRedirect("/cuahang/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CuaHang cuaHang = new CuaHang();
        try {
            BeanUtils.populate(cuaHang, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorMa = CheckString.checkValues(cuaHang.getMa(),"mã");
        errorTen = CheckString.checkValues(cuaHang.getTen(),"tên");
        errorDiaChi = CheckString.checkValues(cuaHang.getDiaChi(),"địa chỉ");
        if (!errorMa.isEmpty()||!errorTen.isEmpty()||!errorDiaChi.isEmpty()){
            response.sendRedirect("/cuahang/edit");
            return;
        }
        cuaHangRepo.update(cuaHang);
        response.sendRedirect("/cuahang/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang cuaHang = cuaHangRepo.getByMa(ma);
        request.setAttribute("ch", cuaHang);
        request.setAttribute("errorma",errorMa);
        request.setAttribute("errorten",errorTen);
        request.setAttribute("errordiachi",errorDiaChi);
        request.setAttribute("navbar","/layout/nhanvien.jsp");
        request.setAttribute("view","/cuahang/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        CuaHang cuaHang = cuaHangRepo.getByMa(ma);
        cuaHangRepo.delete(cuaHang);
        try {
            response.sendRedirect("/cuahang/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
