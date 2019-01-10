package org.jarcem.Servlets;

import org.jarcem.Services.ClassInfoBeanServices;
import org.jarcem.Services.Imp.ClassInfoBeanServicesImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        ClassInfoBeanServices classInfoBeanServices = new ClassInfoBeanServicesImp();
        int result = classInfoBeanServices.deleteClassInfo(req.getParameter("cid"));
        printWriter.println("<script>" + (result == 1 ? "alert('删除成功');location.href='/queryClass';target='main';" : "alert('删除成功');history.back()") + "</script>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
