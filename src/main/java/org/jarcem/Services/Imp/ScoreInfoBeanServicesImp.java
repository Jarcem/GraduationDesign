package org.jarcem.Services.Imp;

import org.jarcem.Beans.ScoreInfoBean;
import org.jarcem.Services.ScoreInfoBeanServices;
import org.jarcem.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreInfoBeanServicesImp implements ScoreInfoBeanServices {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultset = null;
    private String sqlStr = null;
    private List<ScoreInfoBean> scoreInfoBeanList = null;
    private ScoreInfoBean scoreInfoBean = null;
    private int result = 0;

    @Override
    public List<ScoreInfoBean> getAllScoreInfo() {
        scoreInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_score";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                scoreInfoBean = new ScoreInfoBean();
                scoreInfoBean.setSco_id(resultset.getInt("sco_id"));
                scoreInfoBean.setStu_id(resultset.getString("stu_id"));
                scoreInfoBean.setCla_id(resultset.getInt("cla_id"));
                scoreInfoBean.setScore(resultset.getBigDecimal("score"));
                scoreInfoBean.setState(resultset.getString("state"));
                scoreInfoBeanList.add(scoreInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return scoreInfoBeanList;
    }

    @Override
    public List<ScoreInfoBean> getAllScoreInfos(String param) {
        scoreInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_score where state = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, param);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                scoreInfoBean = new ScoreInfoBean();
                scoreInfoBean.setSco_id(resultset.getInt("sco_id"));
                scoreInfoBean.setStu_id(resultset.getString("stu_id"));
                scoreInfoBean.setCla_id(resultset.getInt("cla_id"));
                scoreInfoBean.setScore(resultset.getBigDecimal("score"));
                scoreInfoBean.setState(resultset.getString("state"));
                scoreInfoBeanList.add(scoreInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return scoreInfoBeanList;
    }

    @Override
    public List<ScoreInfoBean> getPersonScoreInfos(String param) {
        scoreInfoBeanList = new ArrayList<>();
        sqlStr = "select * from T_score where stu_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, param);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                scoreInfoBean = new ScoreInfoBean();
                scoreInfoBean.setSco_id(resultset.getInt("sco_id"));
                scoreInfoBean.setStu_id(resultset.getString("stu_id"));
                scoreInfoBean.setCla_id(resultset.getInt("cla_id"));
                scoreInfoBean.setScore(resultset.getBigDecimal("score"));
                scoreInfoBean.setState(resultset.getString("state"));
                scoreInfoBeanList.add(scoreInfoBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return scoreInfoBeanList;
    }

    @Override
    public ScoreInfoBean getScoreInfo(String sco_id) {
        scoreInfoBean = new ScoreInfoBean();
        sqlStr = "select * from T_score where sco_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, sco_id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                scoreInfoBean.setSco_id(resultset.getInt("sco_id"));
                scoreInfoBean.setStu_id(resultset.getString("stu_id"));
                scoreInfoBean.setCla_id(resultset.getInt("cla_id"));
                scoreInfoBean.setScore(resultset.getBigDecimal("score"));
                scoreInfoBean.setState(resultset.getString("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return scoreInfoBean;
    }

    @Override
    public int addScoreInfo(ScoreInfoBean scoreInfoBean) {
        result = 0;
        sqlStr = "insert into T_score(stu_id, cla_id, score, state) values(?, ?, ?, ?)";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, scoreInfoBean.getStu_id());
            preparedStatement.setInt(2, scoreInfoBean.getCla_id());
            preparedStatement.setBigDecimal(3, scoreInfoBean.getScore());
            preparedStatement.setString(4, scoreInfoBean.getState());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return result;
    }

    @Override
    public int deleteScoreInfo(String sco_id) {
        result = 0;
        sqlStr = "delete from T_score where sco_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, sco_id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return result;
    }

    @Override
    public int updateScoreInfo(ScoreInfoBean scoreInfoBean) {
        result = 0;
        sqlStr = "update T_score set stu_id = ?, cla_id = ?, score = ?, state = ? where sco_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, scoreInfoBean.getStu_id());
            preparedStatement.setInt(2, scoreInfoBean.getCla_id());
            preparedStatement.setBigDecimal(3, scoreInfoBean.getScore());
            preparedStatement.setString(4, scoreInfoBean.getState());
            preparedStatement.setInt(5, scoreInfoBean.getSco_id());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return result;
    }

    @Override
    public int checkRepeat(String uid, String cid) {
        scoreInfoBean = new ScoreInfoBean();
        sqlStr = "select * from T_score where stu_id = ? and cla_id = ?";
        try {
            connection = DBUtil.getConn();
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, uid);
            preparedStatement.setString(2, cid);
            resultset = preparedStatement.executeQuery();
            resultset.last();
            result = resultset.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, preparedStatement, resultset);
        }
        return result;
    }
}