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
import java.util.ArrayList;
import java.util.List;

public class QueryUserInfoServlet extends HttpServlet {
    private UserInfoBeanServices userInfoBeanServices = null;
    private List<UserInfoBean> userInfoBeanList = null;
    private String paramStr = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        userInfoBeanServices = new UserInfoBeanServicesImp();
        userInfoBeanList = new ArrayList<>();
        if (req.getParameter("utype") != null){
            switch (req.getParameter("utype")){
                case "admin":paramStr = "admin";break;
                case "student":paramStr = "student";break;
                case "teacher":paramStr = "teacher";break;
            }
            userInfoBeanList = userInfoBeanServices.getAllUsers(paramStr);
        }else{
            userInfoBeanList = userInfoBeanServices.getAllUser();
        }
        req.setAttribute("userList", userInfoBeanList);
        req.getRequestDispatcher("/pages/queryUserInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
