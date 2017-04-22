package org.csu.mypetstore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by pikachu on 2017/3/11.
 */
public class DAOUtil {
    public static boolean query(String sql, Object[] params, ResultSetManipulation manipulation){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (params!=null)
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                manipulation.manipulation(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean update(String sql, Object[] params){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            System.out.println(preparedStatement);
            int count = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return count>0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
