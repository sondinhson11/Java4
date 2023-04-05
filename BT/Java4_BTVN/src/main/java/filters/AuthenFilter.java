package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "AuthenFilter")
public class AuthenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(request, response);
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
    }
}
