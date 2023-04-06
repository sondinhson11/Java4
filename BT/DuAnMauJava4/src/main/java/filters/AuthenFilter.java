package filters;

import domain_model.NhanVienDomain;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/khachhang/*",
        "/sanpham/*",
        "/nsx/*",
        "/nhanvien/*",
        "/mausac/*",
        "/hoadon/*",
        "/hoadonct/*",
        "/giohang/*",
        "/dongSP/*",
        "/cuahang/*",
        "/chucvu/*",
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        NhanVienDomain nv = (NhanVienDomain) session.getAttribute("nv");
        if (nv == null) {
            res.sendRedirect("../login");
        } else {
            filterChain.doFilter(req, res);
        }
    }
}
