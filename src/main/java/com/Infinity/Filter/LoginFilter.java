package com.Infinity.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    public static final String idnex_page = "/index.jsp";
    public static final String backLogin_page = "/backLogin.jsp";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        String currentURL = httpRequest.getRequestURI();
        String ctxPath = httpRequest.getContextPath();

        String targetURL = currentURL.substring(ctxPath.length());

        System.out.println(currentURL);
        System.out.println(ctxPath);
        System.out.println(targetURL);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
