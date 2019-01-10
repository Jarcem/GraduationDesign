package org.jarcem.Servlets;

import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.Imp.ScoreInfoBeanServicesImp;
import org.jarcem.Services.ScoreInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ClassScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("uib");
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        List<ScoreInfoBean> scoreInfoBeanList = scoreInfoBeanServices.getPersonScoreInfos(userInfoBean.getUse_id());
        req.setAttribute("scoreList", scoreInfoBeanList);
        req.getRequestDispatcher("/pages/stuPages/classScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
