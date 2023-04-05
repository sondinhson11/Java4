package controller.admin;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;


@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/edit",     // GET
        "/nhan-vien/update",   // POST
        "/nhan-vien/delete",   // GET
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvrp ;
    private ChucVuRepository cvrp;
    private CuaHangRepository chrp;
    public NhanVienServlet(){
            nvrp = new NhanVienRepository();
            cvrp = new ChucVuRepository();
        chrp = new CuaHangRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
             this.edit(request, response);
        } else if (uri.contains("delete")) {
             this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach6", this.nvrp.findALL());
        request.setAttribute("view","/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }



    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("dscv",this.cvrp.findALL());
        request.setAttribute("dsch",this.chrp.findALL());
        request.setAttribute("view","/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien domainNV = this.nvrp.findByMa(ma);

        if(domainNV == null){
            System.out.println("khong tin thay");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }else{
            this.nvrp.delete(domainNV);
            System.out.println("M di !");
            response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
        }
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien domainNV = this.nvrp.findByMa(ma);
        request.setAttribute("nv",domainNV);
        request.setAttribute("dscv",this.cvrp.findALL());
        request.setAttribute("dsch",this.chrp.findALL());
        request.setAttribute("view","/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri  =  request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");
        if (ma.isEmpty()) {
            session.setAttribute("errMessNV", "Ma Empty");
            response.sendRedirect("/BTVN1_war_exploded/nhan-vien/create");
        } else {
            try {
                new NhanVienRepository().insert(NhanVien.builder().Ma(ma).Ten(ten).TenDem(tenDem).Ho(ho).NgaySinh(new SimpleDateFormat("dd-mm-yyyy")
                        .parse(ngaySinh)).Sdt(sdt).DiaChi(diaChi).MatKhau(matKhau).ch(CuaHang.builder().Id(UUID.fromString(cuaHang)).build())
                        .cv((ChucVu.builder().Id(String.valueOf(chucVu)).build())).trangThai(Integer.parseInt(trangThai)).GioiTinh(gioiTinh).build());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
        }
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien domainNV = this.nvrp.findByMa(ma);
        try {
            BeanUtils.populate(domainNV, request.getParameterMap());
            this.nvrp.update(domainNV);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Java4_BTVN_war_exploded/nhan-vien/index");
    }
}