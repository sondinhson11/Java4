package controllers.users;

import entity.CTSanPham;
import entity.GioHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.CTSanPhamRepository;
import repositories.GioHangRepository;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet({"/giohang/giamsl", "/giohang/tangsl", "/giohang","/giohang/detail","/giohang/delete"})
public class GioHangServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
//        gioHangRepo.insert(new GioHang("GH"+gioHangRepo.getAll().size()+1, "KH1", "Sản Phẩm 1",
//                2, BigDecimal.valueOf(200)));
//        gioHangRepo.insert(new GioHang("GH"+gioHangRepo.getAll().size()+1, "KH1", "Sản Phẩm 2",
//                4, BigDecimal.valueOf(300)));
//        getServletContext().setAttribute("soLuong", gioHangRepo.getAll().size());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.equals("/giohang")) {
            index(request, response);
        } else if (url.contains("/giohang/tangsl")) {
            tangSL(request, response);
        } else if (url.contains("/giohang/giamsl")) {
            giamSL(request, response);
        }else if(url.contains("/giohang/delete")){
            delete(request,response);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();


    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        GioHang gioHang = TrangChuServlet.gioHangRepo.getByMa(ma);
        TrangChuServlet.gioHangRepo.delete(gioHang);
        response.sendRedirect("/giohang");
    }


    private void tangSL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenSp = request.getParameter("ten");
        GioHang gioHang = TrangChuServlet.gioHangRepo.getByTenSP(tenSp);
        gioHang.setSoLuong(gioHang.getSoLuong() + 1);
        TrangChuServlet.gioHangRepo.update(gioHang);
        response.sendRedirect("/giohang");
    }

    private void giamSL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenSp = request.getParameter("ten");
        GioHang gioHang = TrangChuServlet.gioHangRepo.getByTenSP(tenSp);
        gioHang.setSoLuong(gioHang.getSoLuong() - 1);
        if (gioHang.getSoLuong() == 0) {
            TrangChuServlet.gioHangRepo.delete(gioHang);
            response.sendRedirect("/giohang");
            return;
        }
        TrangChuServlet.gioHangRepo.update(gioHang);
        response.sendRedirect("/giohang");
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().setAttribute("soLuong", TrangChuServlet.gioHangRepo.getAll().size());
        request.setAttribute("listcard", TrangChuServlet.gioHangRepo.getAll());
        request.setAttribute("tongTien", TrangChuServlet.gioHangRepo.getTongTienList());
        request.setAttribute("main", "/user/giohang.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }


}
