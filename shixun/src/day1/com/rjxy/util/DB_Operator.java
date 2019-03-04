package day1.com.rjxy.util;

import java.sql.*;
/**
 * Created by lele on 18-1-9.
 * 数据库的注册(插入)　登陆(检查)
 */
public class DB_Operator {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    public void add(String name,String password){

        String url = "insert into user(username,password) values('"+name+"','"+password+"');";
        show(url);

    }

    public void show(String url){
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


    public boolean exit(String name, String password){

        String url = "select * from user where username = '"+name+"'";

        boolean isexit = false;

        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(url);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String a = resultSet.getString(1);
                String b = resultSet.getString(2);

                if(a.equals(name) && b.equals(password)){
                    isexit = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            JDBCTools.releaseDB(resultSet,preparedStatement,connection);
        }

        return isexit;
    }

    public String grap(String name){
        String url = "select * from Info where name = '"+name+"'";

        String a="",b="",c="";

        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(url);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               a = resultSet.getString(2);
               b = resultSet.getString(3);
               c = resultSet.getString(4);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            JDBCTools.releaseDB(resultSet,preparedStatement,connection);
        }

        return a+" "+b+" "+c;

    }

    public void update(String name,int level,int grade,int time){

        String url = "UPDATE Info SET level = '"+level+"',grade='"+grade+"',time='"+time+"' where name = '"+name+"'";

        show(url);
    }

}
