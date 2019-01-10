package org.jarcem.Servlets;

import org.jarcem.Beans.ClassInfoBean;
import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.ClassInfoBeanServices;
import org.jarcem.Services.Imp.ClassInfoBeanServicesImp;
import org.jarcem.Services.Imp.ScoreInfoBeanServicesImp;
import org.jarcem.Services.ScoreInfoBeanServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ApplyClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String cidStr = req.getParameter("cid"), stuidStr = ((UserInfoBean)req.getSession().getAttribute("uib")).getUse_id();
        ScoreInfoBean scoreInfoBean = new ScoreInfoBean();
        ScoreInfoBeanServices scoreInfoBeanServices = new ScoreInfoBeanServicesImp();
        ClassInfoBeanServices classInfoBeanServices = new ClassInfoBeanServicesImp();

        if (cidStr != null){
            if (scoreInfoBeanServices.checkRepeat(stuidStr, cidStr) == 0 ){
                scoreInfoBean.setStu_id(stuidStr);
                scoreInfoBean.setCla_id(Integer.valueOf(cidStr));
                scoreInfoBean.setState("audit");
                int result = scoreInfoBeanServices.addScoreInfo(scoreInfoBean);
                printWriter.println("<script>" + (result == 1 ? "alert('申请成功');location.href='/classScore'; target='main'" : "alert('申请失败');history.back()") + "</script>");
            }else{
                printWriter.println("<script>alert('已经选修该门课程');history.back();</script>");
            }
        }else{
            List<ClassInfoBean> classInfoBeanList = classInfoBeanServices.getAllClass();
            req.setAttribute("classList", classInfoBeanList);
            req.getRequestDispatcher("/pages/stuPages/applyClass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
