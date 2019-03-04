package day1.com.rjxy.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * 资源类　用于数据库的连接　与释放资源
 * */
public class JDBCTools {

    public static Connection getConnection() throws ClassNotFoundException, SQLException,IOException {

        //操作properties文件的代码
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("jdbcResource.properties");

        properties.load(inputStream);

        String jdbcDirver = properties.getProperty("jdbcDirver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }

    public static void releaseDB(ResultSet resultSet,Statement statement,
                                 Connection connection){
        if(resultSet != null){
            try{
                resultSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(statement != null){
            try{
                statement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(connection != null){
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }




}