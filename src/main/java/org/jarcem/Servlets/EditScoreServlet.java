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

public class EditScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        ScoreInfoBean scoreInfoBean = new ScoreInfoBean();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        scoreInfoBean = scoreInfoBeanServices.getScoreInfo(req.getParameter("cid"));
        req.setAttribute("score", scoreInfoBean);
        req.getRequestDispatcher("/pages/editScore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        if (StringUtil.isNotNull(req.getParameter("scid")) && StringUtil.isNotNull(req.getParameter("sic")) && StringUtil.isNotNull(req.getParameter("cid"))) {
            ScoreInfoBean scoreInfoBean = scoreInfoBeanServices.getScoreInfo(req.getParameter("scid"));
            scoreInfoBean.setStu_id(req.getParameter("sid"));
            scoreInfoBean.setCla_id(Integer.valueOf(req.getParameter("cid")));
            scoreInfoBean.setScore(BigDecimal.valueOf(Double.valueOf(req.getParameter("sco"))));
            printWriter.println("<script>" + (scoreInfoBeanServices.updateScoreInfo(scoreInfoBean) == 1 ? "alert('修改成功');location.href='/scoreManage'" : "alert('修改失败');history.back();") + "</script>");
        }else{
            printWriter.println("<script>alert('除成绩外，不能有空字段');history.back()</script>");
        }
    }
}
