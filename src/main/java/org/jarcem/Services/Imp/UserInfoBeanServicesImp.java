package org.jarcem.Services.Imp;

import org.jarcem.Beans.UserInfoBean;
import org.jarcem.Services.UserInfoBeanServices;
import org.jarcem.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoBeanServicesImp implements UserInfoBeanServices {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String sqlStr = null;
    private List<UserInfoBean> userInfoBeanList = null;
    private UserInfoBean userInfoBean = null;
    private int result = 0;


    @Override
    public List<UserInfoBean> getAllUser() {
        userInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_user";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userInfoBean = new UserInfoBean();
                userInfoBean.setUse_id(resultSet.getString("use_id"));
                userInfoBean.setUse_name(resultSet.getString("use_name"));
                userInfoBean.setUse_sex(resultSet.getString("use_sex"));
                userInfoBean.setUse_type(resultSet.getString("use_type"));
                userInfoBean.setUse_telephone(resultSet.getString("use_telephone"));
                userInfoBean.setUse_password(resultSet.getString("use_password"));
                userInfoBean.setReserve(resultSet.getString("reserve"));
                userInfoBeanList.add(userInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return userInfoBeanList;
    }

    @Override
    public List<UserInfoBean> getAllUsers(String str) {
        userInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_user where use_type = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, str);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userInfoBean = new UserInfoBean();
                userInfoBean.setUse_id(resultSet.getString("use_id"));
                userInfoBean.setUse_name(resultSet.getString("use_name"));
                userInfoBean.setUse_sex(resultSet.getString("use_sex"));
                userInfoBean.setUse_type(resultSet.getString("use_type"));
                userInfoBean.setUse_telephone(resultSet.getString("use_telephone"));
                userInfoBean.setUse_password(resultSet.getString("use_password"));
                userInfoBean.setReserve(resultSet.getString("reserve"));
                userInfoBeanList.add(userInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return userInfoBeanList;
    }

    @Override
    public UserInfoBean getUserInfo(String use_id) {
        userInfoBean = new UserInfoBean();
        sqlStr = "select * from T_user where use_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, use_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userInfoBean.setUse_id(resultSet.getString("use_id"));
                userInfoBean.setUse_name(resultSet.getString("use_name"));
                userInfoBean.setUse_sex(resultSet.getString("use_sex"));
                userInfoBean.setUse_type(resultSet.getString("use_type"));
                userInfoBean.setUse_telephone(resultSet.getString("use_telephone"));
                userInfoBean.setUse_password(resultSet.getString("use_password"));
                userInfoBean.setReserve(resultSet.getString("reserve"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return userInfoBean;
    }

    @Override
    public int loginCheck(String uid, String pwd) {
        userInfoBean = new UserInfoBean();
        sqlStr = "select * from T_user where use_id = ? and use_password = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, uid);
            preparedStatement.setString(2, pwd);
            resultSet = preparedStatement.executeQuery();
            resultSet.last();
            result = resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return result;
    }

    @Override
    public int registerUser(UserInfoBean userInfoBean) {
        result = 0;
        sqlStr = "insert into T_user values(?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, userInfoBean.getUse_id());
            preparedStatement.setString(2, userInfoBean.getUse_name());
            preparedStatement.setString(3, userInfoBean.getUse_sex());
            preparedStatement.setString(4, userInfoBean.getUse_type());
            preparedStatement.setString(5, userInfoBean.getUse_telephone());
            preparedStatement.setString(6, userInfoBean.getUse_password());
            preparedStatement.setString(7, userInfoBean.getReserve());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return result;
    }

    @Override
    public int deleteUser(String use_id) {
        result = 0;
        sqlStr = "delete from T_user where use_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, use_id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return result;
    }

    @Override
    public int updateUser(UserInfoBean userInfoBean) {
        result = 0;
        sqlStr = "update T_user set use_id = ?, use_name = ?, use_sex = ?, use_type = ?, use_telephone = ?, use_password = ?, reserve = ? where use_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, userInfoBean.getUse_id());
            preparedStatement.setString(2, userInfoBean.getUse_name());
            preparedStatement.setString(3, userInfoBean.getUse_sex());
            preparedStatement.setString(4, userInfoBean.getUse_type());
            preparedStatement.setString(5, userInfoBean.getUse_telephone());
            preparedStatement.setString(6, userInfoBean.getUse_password());
            preparedStatement.setString(7, userInfoBean.getReserve());
            preparedStatement.setString(8, userInfoBean.getUse_id());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, resultSet);
        }
        return result;
    }
}
