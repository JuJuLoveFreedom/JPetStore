package org.csu.mypetstore.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pikachu on 17-3-2.
 */
public class DBUtil {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mypetstore?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=true","root","123123");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection connection){

        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(DBUtil.getConnection());
    }
}
