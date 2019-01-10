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

public class ExamineClassServlet extends HttpServlet {
    private ScoreInfoBeanServices scoreInfoBeanServices = null;
    private List<ScoreInfoBean> scoreInfoBeanListn = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        scoreInfoBeanListn = scoreInfoBeanServices.getAllScoreInfo();
        String paramStr = "";
        if (req.getParameter("state") != null){
            switch (req.getParameter("state")){
                case "audit":paramStr = "audit";break;
                case "success":paramStr = "success";break;
                case "refuse":paramStr = "refuse";break;
            }
            scoreInfoBeanListn = scoreInfoBeanServices.getAllScoreInfos(paramStr);
        }else{
            scoreInfoBeanListn = scoreInfoBeanServices.getAllScoreInfo();
        }
        req.setAttribute("scoreList", scoreInfoBeanListn);
        req.getRequestDispatcher("/pages/admPages/examineClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}