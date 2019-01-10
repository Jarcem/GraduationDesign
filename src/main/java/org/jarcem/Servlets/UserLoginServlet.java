package org.jarcem.Servlets;

import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.UserInfoBeanServices;
import org.jarcem.Services.Imp.UserInfoBeanServicesImp;
import org.jarcem.Util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8;");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession();
        UserInfoBeanServices userInfoBeanServices = new UserInfoBeanServicesImp();
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setUse_id(req.getParameter("username"));
        userInfoBean.setUse_password(req.getParameter("password"));
        if (StringUtil.isNotNull(userInfoBean.getUse_id()) && StringUtil.isNotNull(userInfoBean.getUse_password())) {
            if (userInfoBeanServices.loginCheck(userInfoBean.getUse_id(), userInfoBean.getUse_password()) == 1) {
                userInfoBean = userInfoBeanServices.getUserInfo(userInfoBean.getUse_id());
                session.setAttribute("uib", userInfoBean);
                req.getRequestDispatcher("/mainPage").forward(req, resp);
            } else {
                printWriter.println("<script>alert('登录失败');history.back();</script>");
            }
        }
    }
}