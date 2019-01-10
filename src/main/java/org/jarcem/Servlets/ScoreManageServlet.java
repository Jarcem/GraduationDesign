package org.jarcem.Servlets;

import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Services.Imp.ScoreInfoBeanServicesImp;
import org.jarcem.Services.ScoreInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        List<ScoreInfoBean> scoreInfoBeanList = new ArrayList<>();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        scoreInfoBeanList = scoreInfoBeanServices.getAllScoreInfos("success");
        req.setAttribute("scoreList", scoreInfoBeanList);
        req.getRequestDispatcher("/pages/scoreManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
