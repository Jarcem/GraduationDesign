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
import java.util.ArrayList;
import java.util.List;

public class QueryClassServlet extends HttpServlet {
    private ClassInfoBeanServices classInfoBeanServices = null;
    private List<ClassInfoBean> classInfoBeanList = null;
    private ClassInfoBean classInfoBean = null;
    private PrintWriter printWriter = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        classInfoBeanServices = new ClassInfoBeanServicesImp();
        classInfoBeanList = new ArrayList<>();
        classInfoBeanList = classInfoBeanServices.getAllClass();
        req.setAttribute("classList", classInfoBeanList);
        req.getRequestDispatcher("/pages/queryClass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
