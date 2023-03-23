package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/hoadon1/index"})
public class HoaDonServlet extends HttpServlet {

//    ChucVuRepository chucVuRepo;

    @Override
    public void init() throws ServletException {
//        chucVuRepo = new ChucVuRepository();
//        chucVuRepo.insert(new ChucVu("1", "CV1", "Nhân Viên"));
//        chucVuRepo.insert(new ChucVu("2", "CV2", "Chủ cửa hàng"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/hoadon1/index")) {
            index(request, response);
        } else {
            index(request, response);
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/layout/hoadon.jsp");
        request.setAttribute("navbar",null);
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }



}
