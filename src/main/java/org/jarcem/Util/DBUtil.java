package org.jarcem.Util;

import java.sql.*;

public class DBUtil {
    private static String driver_class_name = "com.mysql.jdbc.Driver";
    private static String connection_url = "jdbc:mysql://.../ConstructionDB";
    private static String user_name = "tokyosqlserver";
    private static String password = "";

    static {
        try {
            Class.forName(driver_class_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(connection_url, user_name, password);
        return connection;
    }

    public static void closeAll(Connection con, Statement sta, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
