package controllers.admin;

import entity.CTSanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import repositories.CTSanPhamRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet({"/ctsanpham/index", "/ctsanpham/create", "/ctsanpham/store",
        "/ctsanpham/edit", "/ctsanpham/update", "/ctsanpham/delete"})
public class CTSanPhamServlet extends HttpServlet {
    public static CTSanPhamRepository ctSanPhamRepo;


    @Override
    public void init() throws ServletException {
        ctSanPhamRepo = new CTSanPhamRepository();
        ctSanPhamRepo.insert(new CTSanPham("CTSP1", "Sản Phẩm 1", "Bánh", "Yellow",
                "Nhà Sản Xuất 1", 1, "Đây là sp1", 20,
                BigDecimal.valueOf(200), BigDecimal.valueOf(300)));
        ctSanPhamRepo.insert(new CTSanPham("CTSP2", "Sản Phẩm 2", "Bánh", "Yellow",
                "Nhà Sản Xuất 1", 1, "Đây là sp1", 20,
                BigDecimal.valueOf(400), BigDecimal.valueOf(500)));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/ctsanpham/delete")) {
            delete(request, response);
        } else if (url.contains("/ctsanpham/create")) {
            create(request, response);
        } else if (url.contains("/ctsanpham/edit")) {
            edit(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI().toString();
        if (url.contains("/ctsanpham/store")) {
            try {
                store(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            update(request, response);
        }

    }

    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", ctSanPhamRepo.getAll());
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/index.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/create.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void store(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        CTSanPham ctSanPham = new CTSanPham();
        try {
            BeanUtils.populate(ctSanPham, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Create a factory for disk-based file items
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//// Configure a repository (to ensure a secure temp location is used)
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(repository);
//
//// Create a new file upload handler
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//// Parse the request
//        List<FileItem> items = upload.parseRequest(request.);
//
////
//        Iterator<FileItem> iter = items.iterator();
//        while (iter.hasNext()) {
//            FileItem item = iter.next();
//
//            if (item.isFormField()) {
//                String name = item.getName();
//                String value = item.getString();
//                System.out.println("name"+"="+name+", "+"value = "+value);
//            } else {
//            }
//        }

//
        ctSanPhamRepo.insert(ctSanPham);
        response.sendRedirect("/ctsanpham/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CTSanPham ctSanPham = new CTSanPham();
        try {
            BeanUtils.populate(ctSanPham, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ctSanPhamRepo.update(ctSanPham);
        response.sendRedirect("/ctsanpham/index");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CTSanPham ctsanpham = ctSanPhamRepo.getByMa(ma);
        request.setAttribute("ctsp", ctsanpham);
        request.setAttribute("navbar", "/layout/sanpham.jsp");
        request.setAttribute("view", "/ctsanpham/edit.jsp");
        request.getRequestDispatcher("/layout.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CTSanPham ctsanpham = ctSanPhamRepo.getByMa(ma);
        ctSanPhamRepo.delete(ctsanpham);
        response.sendRedirect("/ctsanpham/index");
    }
}
