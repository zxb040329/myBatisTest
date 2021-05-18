package com.qf.test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.qf.entity.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperateByJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库链接
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/1905_demo?characterEncoding=utf-8", "root", "root");
            // 定义sql语句？表示占位符
            String sql = "select * from t_user where id = ?";
            //select * from t_user where id = #{id}
            // 获取预处理statement
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            // 设置参数，第⼀个参数为sql语句中参数的序号(从1开始)，第⼆个参数为设置的参数值
            preparedStatement.setInt(1, 3);
            // 向数据库发出sql执⾏查询，查询出结果集
            resultSet = preparedStatement.executeQuery();

            final User user = new User();
            // 遍历查询结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                // 封装User
                user.setId(id);
                user.setName(username);
            }
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {


            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
