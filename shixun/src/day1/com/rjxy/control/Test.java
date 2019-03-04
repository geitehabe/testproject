package day1.com.rjxy.control;

import day1.com.rjxy.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by lele on 18-1-9.
 */
public class Test {
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String name = "aaa";
        String password = "cccccc";
        String url = "insert into user(username,password) values('"+name+"','"+password+"');";

        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(url);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            JDBCTools.releaseDB(resultSet,preparedStatement,connection);
        }
    }


}



