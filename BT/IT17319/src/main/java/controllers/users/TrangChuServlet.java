package controllers.users;

import controllers.admin.CTSanPhamServlet;
import entity.CTSanPham;
import entity.ChucVu;
import entity.GioHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.GioHangRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

@WebServlet({"/trangchu/index","/product/detail","/trangchu/sanpham","/trangchu/addcard"})
public class TrangChuServlet extends HttpServlet {

//    CTSanPhamServlet.ctSanPhamRepository CTSanPhamServlet.ctSanPhamRepo;
    public static GioHangRepository gioHangRepo;

    @Override
    public void init() throws ServletException {
//        CTSanPhamServlet.ctSanPhamRepo = new CTSanPhamServlet.ctSanPhamRepository();
//        CTSanPhamServlet.ctSanPhamRepo.insert(new CTSanPham("CTSP1", "Sản Phẩm 1", "Bánh", "Yellow",
//                "Nhà Sản Xuất 1", 1, "Đây là sp1", 20,
//                BigDecimal.valueOf(200), BigDecimal.valueOf(300)));
//        CTSanPhamServlet.ctSanPhamRepo.insert(new CTSanPham("CTSP2", "Sản Phẩm 2", "Bánh", "Yellow",
//                "Nhà Sản Xuất 1", 1, "Đây là sp1", 20,
//                BigDecimal.valueOf(400), BigDecimal.valueOf(500)));
        gioHangRepo = new GioHangRepository();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/trangchu/index")) {
            index(request, response);
        }else if(url.contains("/product/detail")){
            detailProduct(request, response);
        }else if(url.contains("/trangchu/sanpham")){
            showProduct(request, response);
        }else if(url.contains("/trangchu/addcard")){
            addCard(request, response);
        }

    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();


    }
    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProducts", CTSanPhamServlet.ctSanPhamRepo.getAll());
        request.setAttribute("main","/user/sanpham.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }
    private void addCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tenSp = request.getParameter("ten");
        String gia = request.getParameter("gia");
        GioHang gh = gioHangRepo.getByTenSP(tenSp);
        if (gh==null){
            gh= new GioHang("GH"+(gioHangRepo.getAll().size()+1), "KH1", tenSp, 1, BigDecimal.valueOf(Long.parseLong(gia)));
            gioHangRepo.insert(gh);
        }else{
            gh.setSoLuong(gh.getSoLuong()+1);
            gioHangRepo.update(gh);
        }
        response.sendRedirect("/trangchu/index");
    }
    private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CTSanPham ctSanPham = CTSanPhamServlet.ctSanPhamRepo.getByMa(id);
        request.setAttribute("spDetail", ctSanPham);
        request.setAttribute("main","/user/detailproduct.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().setAttribute("soLuong", gioHangRepo.getAll().size());
        request.setAttribute("listProduct", CTSanPhamServlet.ctSanPhamRepo.getAll());
        request.setAttribute("main","/user/trangchu.jsp");
        request.getRequestDispatcher("/layoutkh.jsp").forward(request, response);
    }


}
