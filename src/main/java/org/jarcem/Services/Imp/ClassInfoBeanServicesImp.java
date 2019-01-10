package org.jarcem.Services.Imp;

import org.jarcem.Beans.ClassInfoBean;
import org.jarcem.Services.ClassInfoBeanServices;
import org.jarcem.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassInfoBeanServicesImp implements ClassInfoBeanServices {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultset = null;
    private String sqlStr = null;
    private List<ClassInfoBean> classInfoBeanList = null;
    private ClassInfoBean classInfoBean = null;
    private int result = 0;

    @Override
    public List<ClassInfoBean> getAllClass() {
        classInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_class";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                classInfoBean = new ClassInfoBean();
                classInfoBean.setCla_id(resultset.getInt("cla_id"));
                classInfoBean.setCla_name(resultset.getString("cla_name"));
                classInfoBean.setTea_id(resultset.getString("tea_id"));
                classInfoBeanList.add(classInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return classInfoBeanList;
    }

    @Override
    public ClassInfoBean getClassInfo(String class_id) {
        sqlStr = "select * from T_class where cla_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, class_id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                classInfoBean = new ClassInfoBean();
                classInfoBean.setCla_id(resultset.getInt("cla_id"));
                classInfoBean.setCla_name(resultset.getString("cla_name"));
                classInfoBean.setTea_id(resultset.getString("tea_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return classInfoBean;
    }

    @Override
    public int addClassInfo(ClassInfoBean classInfoBean) {
        result = 0;
        sqlStr = "insert into T_class(cla_name, tea_id) values (?, ?)";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, classInfoBean.getCla_name());
            preparedStatement.setString(2, classInfoBean.getTea_id());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteClassInfo(String class_id) {
        result = 0;
        sqlStr="delete from T_class where cla_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, class_id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return result;
    }

    @Override
    public int updateClassInfo(ClassInfoBean classInfoBean) {
        result = 0;
        sqlStr = "update T_class set cla_name = ?, tea_id = ? where cla_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, classInfoBean.getCla_name());
            preparedStatement.setString(2, classInfoBean.getTea_id());
            preparedStatement.setInt(3, classInfoBean.getCla_id());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}