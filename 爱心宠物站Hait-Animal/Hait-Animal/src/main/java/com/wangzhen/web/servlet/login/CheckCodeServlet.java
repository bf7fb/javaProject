package com.wangzhen.web.servlet.login; /**
 * @author wangzhen
 * @creat ${YEAR-}${MONTH-}$DAY-11:45
 */

import com.wangzhen.util.CheckCodeUtil;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 生成机器验证码
        ServletOutputStream ros = response.getOutputStream();
        String checkCodeGen = CheckCodeUtil.outputVerifyImage(100, 50, ros, 4);
        //将验证码存储的session中 因为注册要访问checkcodeservlet和registerservlet 两次请求
        // 两次求情 共同都要访问 验证码
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCodeGen);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
