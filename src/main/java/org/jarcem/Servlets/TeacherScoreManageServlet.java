package org.jarcem.Servlets;

import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Services.Imp.ScoreInfoBeanServicesImp;
import org.jarcem.Services.ScoreInfoBeanServices;
import org.jarcem.Util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TeacherScoreManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        List<ScoreInfoBean> scoreInfoBeanList = new ArrayList<>();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        scoreInfoBeanList = scoreInfoBeanServices.getAllScoreInfos("success");
        req.setAttribute("scoreList", scoreInfoBeanList);
        req.getRequestDispatcher("/pages/teaPages/scoreManage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        ScoreInfoBean scoreInfoBean = scoreInfoBeanServices.getScoreInfo(req.getParameter("scoid"));
        if(StringUtil.isNotNull(req.getParameter("score"))){
            if (StringUtil.isNumeric(req.getParameter("score"))) {
                scoreInfoBean.setScore(BigDecimal.valueOf(Double.valueOf(req.getParameter("score"))));
                int result = scoreInfoBeanServices.updateScoreInfo(scoreInfoBean);
                printWriter.println("<script>" + (result == 1 ? "alert('成功');location.href='/teaScoreManage'; target='main'" : "alert('失败');history.back()") + "</script>");
            }else{
                printWriter.println("<script>alert('成绩不能为字符');history.back();</script>");
            }
        }else{
            printWriter.println("<script>alert('成绩不能为空');history.back();</script>");
        }
    }
}
