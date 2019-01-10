package org.jarcem.Servlets;

import org.jarcem.Beans.ClassInfoBean;
import org.jarcem.Services.ClassInfoBeanServices;
import org.jarcem.Services.Imp.ClassInfoBeanServicesImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditClassServlet extends HttpServlet {
    private ClassInfoBeanServices classInfoBeanServices = null;
    private ClassInfoBean classInfoBean = null;
    private PrintWriter printWriter = null;
    private int result = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        classInfoBeanServices = new ClassInfoBeanServicesImp();
        classInfoBean = classInfoBeanServices.getClassInfo(req.getParameter("cid"));
        req.setAttribute("clas", classInfoBean);
        req.setAttribute("action", "/editClass");
        req.getRequestDispatcher("/pages/admPages/addNewClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        printWriter = resp.getWriter();
        classInfoBeanServices = new ClassInfoBeanServicesImp();
        classInfoBean = new ClassInfoBean();
        classInfoBean.setCla_id(Integer.valueOf(req.getParameter("cid")));
        classInfoBean.setCla_name(req.getParameter("cname"));
        classInfoBean.setTea_id(req.getParameter("tid"));
        result = classInfoBeanServices.updateClassInfo(classInfoBean);
        printWriter.println("<script>" + (result == 1 ? "alert('修改成功');location.href='/queryClass'; target='main'" : "alert('修改失败');history.back()") + "</script>");
    }
}
