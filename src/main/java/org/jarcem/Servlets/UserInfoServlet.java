package org.jarcem.Servlets;

import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.Imp.UserInfoBeanServicesImp;
import org.jarcem.Services.UserInfoBeanServices;
import org.jarcem.Util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class UserInfoServlet extends HttpServlet {
    private HttpSession session = null;
    private UserInfoBeanServices userInfoBeanServices = null;
    private UserInfoBean userInfoBean = null;
    private PrintWriter printWriter = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        session = req.getSession();
        userInfoBean = (UserInfoBean) session.getAttribute("uib");
        req.setAttribute("usb", userInfoBean);
        req.getRequestDispatcher("/pages/userInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        printWriter = resp.getWriter();
        session = req.getSession();
        userInfoBeanServices = new UserInfoBeanServicesImp();
        userInfoBean = (UserInfoBean) session.getAttribute("uib");
        Enumeration<String> e = req.getParameterNames();
        String paramName = null;
        while (e.hasMoreElements()){
            paramName = e.nextElement();
            switch (paramName){
                case "newtelephone":{
                    if (StringUtil.isNotNull(req.getParameter(paramName))){
                        userInfoBean.setUse_telephone(req.getParameter(paramName));
                        int result = userInfoBeanServices.updateUser(userInfoBean);
                        printWriter.println("<script>alert('修改"+(result==1?"成功":"失败")+"');"+(result==1?"location.href='/userInfo';target='mainWindow'":"history.back();")+"</script>");
                    }else{
                        printWriter.println("<script>alert('新号码不能为空');</script>");
                    }
                };break;
                case "oldpassword":{
                    if (StringUtil.isNotNull(req.getParameter(paramName)) && userInfoBean.getUse_password().equals(req.getParameter(paramName))){
                        if (!userInfoBean.getUse_password().equals(req.getParameter("newpassword"))){
                            if (StringUtil.isNotNull(req.getParameter("newpassword"))){
                                userInfoBean.setUse_password(req.getParameter("newpassword"));
                                int result = userInfoBeanServices.updateUser(userInfoBean);
                                printWriter.println("<script>alert('修改"+(result==1?"成功":"失败")+"');"+(result==1?"location.href='/userInfo';target='mainWindow'":"history.back();")+"</script>");
                            }else{
                                printWriter.println("<script>alert('新密码不能为空');history.back();</script>");
                            }
                        }else{
                            printWriter.println("<script>alert('新密码不能与原密码相同');history.back();</script>");
                        }
                    }else{
                        printWriter.println("<script>alert('原密码错误');history.back();</script>");
                    }
                };break;
            }
        }
    }
}
