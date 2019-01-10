package org.jarcem.Servlets;

import org.jarcem.Beans.UserInfoBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MainPageServlet extends HttpServlet {

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
        String param = null;
        UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("uib");
        switch (userInfoBean.getUse_type()){
            case "student":param="/pages/stuPages/";break;
            case "teacher":param="/pages/teaPages/";break;
            case "admin":param="/pages/admPages/";break;
        }
        param+="leftMainMenu.jsp";
        req.setAttribute("leftmenuurl", param);
        req.getRequestDispatcher("/pages/main.jsp").forward(req, resp);
    }
}
