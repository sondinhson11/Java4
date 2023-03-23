package controllers.admin;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import repositories.NhanVienRepository;
import viewmodel.Login;
import viewmodel.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/login/viewnv", "/login/submitnv","/login/viewkh", "/login/submitkh"})
public class DangNhapServlet extends HttpServlet {

    NhanVienRepository nhanVienRepo;
    KhachHangRepository khachHangRepo;
    Boolean error = false;
    Boolean errorkh = false;

    @Override
    public void init() throws ServletException {
        nhanVienRepo = new NhanVienRepository();
        khachHangRepo = new KhachHangRepository();
        nhanVienRepo.insert(new NhanVien("NV1", "Lê", "Thị", "Hạnh", "Nữ",
                "1/1/2003", "Hà Nam", "0389478937", "123", 0));
        nhanVienRepo.insert(new NhanVien("NV2", "Đinh", "Tuấn", "Anh", "Nam",
                "28/7/2003", "Hoà Bình", "0389478937", "123", 0));
        khachHangRepo.insert(new QLKhachHang("PH1", "Anh", "Tuấn", "Đinh",
                "28/7/2003", "0389478937", "Yên Thuỷ", "123", "Việt Nam",
                "Hà Nam"));
        khachHangRepo.insert(new QLKhachHang("PH2", "Anh", "Tuấn", "Đinh",
                "28/7/2003", "0389478937", "Yên Thuỷ", "123", "USA",
                "Hoà Bình"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/login/viewnv")) {
            index(request, response);
        } else {
            loginkh(request, response);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/login/submitnv")) {
//            submitnv(request, response);
        } else {
            submidkh(request, response);
        }

    }
    private void loginkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (errorkh){
            request.setAttribute("check", "Tài khoản hoặc mật khẩu sai");
        }
        request.getRequestDispatcher("/layout/index.jsp").forward(request, response);
    }

    private void submidkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login login = new Login();
        try {
            BeanUtils.populate(login, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (khachHangRepo.checkUser(login)) {
            errorkh = false;
            response.sendRedirect("/trangchu/index");

        } else {
            errorkh = true;
            response.sendRedirect("/login/viewkh");
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (error){
            request.setAttribute("check", "Tài khoản hoặc mật khẩu sai");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void submitnv(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        Login login = new Login();
            BeanUtils.populate(login, request.getParameterMap());

        if (nhanVienRepo.checkUser(login)) {
            error = false;
            response.sendRedirect("/chucvu/index");
        } else {
            error = true;
            response.sendRedirect("/login/viewnv");
        }
    }


}
