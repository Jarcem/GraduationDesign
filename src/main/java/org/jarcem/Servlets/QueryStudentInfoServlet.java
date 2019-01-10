package org.jarcem.Servlets;

import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.Imp.UserInfoBeanServicesImp;
import org.jarcem.Services.UserInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryStudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        UserInfoBeanServices userInfoBeanServices = new UserInfoBeanServicesImp();
        List<UserInfoBean> userInfoBeanList = new ArrayList<>();
        userInfoBeanList = userInfoBeanServices.getAllUsers("student");
        req.setAttribute("userList", userInfoBeanList);
        req.getRequestDispatcher("/pages/teaPages/studentInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
