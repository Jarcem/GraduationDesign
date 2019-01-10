package org.jarcem.Servlets;

import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.Imp.UserInfoBeanServicesImp;
import org.jarcem.Services.UserInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    private UserInfoBeanServices userInfoBeanServices = null;
    private UserInfoBean userInfoBean = null;
    private PrintWriter printWriter = null;
    private int result = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("action", "/addUser");
        req.getRequestDispatcher("/pages/admPages/editUserInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        printWriter = resp.getWriter();
        userInfoBeanServices = new UserInfoBeanServicesImp();
        userInfoBean = new UserInfoBean();
        userInfoBean.setUse_id(req.getParameter("uid"));
        userInfoBean.setUse_name(req.getParameter("uname"));
        userInfoBean.setUse_sex(req.getParameter("usex"));
        userInfoBean.setUse_type(req.getParameter("utype"));
        userInfoBean.setUse_telephone(req.getParameter("utel"));
        userInfoBean.setUse_password(req.getParameter("upwd"));
        userInfoBean.setReserve(req.getParameter("ure"));
        result = userInfoBeanServices.registerUser(userInfoBean);
        printWriter.println("<script>" + (result == 1 ? "alert('添加成功');location.href='/queryUser'; target='main'" : "alert('添加失败');history.back()") + "</script>");
    }
}
