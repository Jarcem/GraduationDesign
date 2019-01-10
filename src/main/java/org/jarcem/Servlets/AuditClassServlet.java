package org.jarcem.Servlets;

import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Services.Imp.ScoreInfoBeanServicesImp;
import org.jarcem.Services.ScoreInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuditClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        ScoreInfoBean scoreInfoBean = new ScoreInfoBean();
        String finalState = null;
        switch (req.getParameter("state")){
            case "dopass":finalState = "success";break;
            case "dorefuse":finalState = "refuse";break;
        }
        scoreInfoBean = scoreInfoBeanServices.getScoreInfo(req.getParameter("cid"));
        scoreInfoBean.setState(finalState);
        scoreInfoBeanServices.updateScoreInfo(scoreInfoBean);
        List<ScoreInfoBean> scoreInfoBeanListn = scoreInfoBeanServices.getAllScoreInfo();
        req.setAttribute("scoreList", scoreInfoBeanListn);
        req.getRequestDispatcher("/pages/admPages/examineClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
