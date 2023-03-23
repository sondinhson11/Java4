package controllers.admin;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import viewmodel.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/khach-hang/index", "/khach-hang/create", "/khach-hang/store",
        "/khach-hang/edit", "/khach-hang/update", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {

    private KhachHangRepository khRepo ;
    @Override
    public void init() {
        khRepo = new KhachHangRepository();
        khRepo.insert(new QLKhachHang("PH1", "Anh", "Tuấn", "Đinh",
                "28/7/2003", "0389478937", "Yên Thuỷ", "123", "Việt Nam",
                "Hà Nam"));
        khRepo.insert(new QLKhachHang("PH2", "Anh", "Tuấn", "Đinh",
                "28/7/2003", "0389478937", "Yên Thuỷ", "123", "USA",
                "Hoà Bình"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String url = request.getRequestURI();
        if (url.contains("/khach-hang/create")) {
            create(request, response);
        } else if (url.contains("/khach-hang/index")) {
            index(request, response);
        }else if (url.contains("/khach-hang/delete")) {
            delete(request, response);
        } else if(url.contains("/khach-hang/edit")){
            edit(request,response);
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("/khachhang/store")){
            store(request, response);
        }else{
            update(request, response);
        }
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        QLKhachHang kh = khRepo.findByMa(ma);
        request.setAttribute("kh",kh);
        try {
            request.getRequestDispatcher("/khachhang/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = khRepo.findByMa(ma);
        khRepo.delete(kh);
        response.sendRedirect("/khach-hang/index");
    }



    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/khachhang/add.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String dem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
//        QLKhachHang k = BeanUtils.getProperty()
        QLKhachHang kh = new QLKhachHang(ma, ten, dem, ho, ngaySinh, sdt, diaChi, matKhau, quocGia, thanhPho);
        khRepo.insert(kh);
        response.sendRedirect("/khach-hang/index");
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("list", khRepo.getAll());
        request.getRequestDispatcher("/khachhang/index.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        QLKhachHang kh = new QLKhachHang();
        try {
            BeanUtils.populate(kh,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        khRepo.update(kh);
        response.sendRedirect("/khach-hang/index");
    }
}
