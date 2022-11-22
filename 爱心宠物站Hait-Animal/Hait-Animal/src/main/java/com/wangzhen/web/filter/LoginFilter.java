package com.wangzhen.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author wangzhen
 * @creat ${YEAR-}${MONTH-}$DAY-10:17
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 获取session对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        // 如果不登陆而强制访问 user为null  获取session域中值 登陆成功将user存储的session中
        // 注意：第一次访问登陆页面时,没有点击登陆按钮 没有访问loginServlet是没有user这个键的
        // 所以user的值默认为null
        Object user = session.getAttribute("user");

        // 判断访问资源路径是否和登录注册相关 与登录注册相关的不拦截 因为登录注册不属于强制访问网页内部资源
        String[] urls = new String[]{"/login.jsp","/loginServlet","administratorLogin.jsp","administratorLoginServlet","/imgs/","animalImgs","/css/","/register.jsp","/registerServlet","/checkCodeServlet"};
        // 获取当前访问资源路径
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if(url.contains(u)){
                // 放行
                chain.doFilter(request,response);
                return;
            }
        }

        // 判断
        if(user != null){
            // 登录成功 放行
            chain.doFilter(request,response);
        }else {
            // 不输入账号密码强制访问 user为null 进行拦截 并跳转到登陆页面 提示信息
            req.setAttribute("login_msg","您尚未登录~");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
