package com.wildcodeschool.sharemybrain.repository;

import com.wildcodeschool.sharemybrain.entity.User;
import com.wildcodeschool.sharemybrain.util.JdbcUtils;

import java.sql.*;

public class UserRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/share_my_brain?serverTimezone=GMT";
    private final static String DB_USER = "poule";
    private final static String DB_PASSWORD = "p0uleR3qu3st?";

    public boolean findAnyUsername(String userName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ?"
            );
            statement.setString(1, userName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return false;
    }

    public boolean findAnyEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE email = ?"
            );
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return false;
    }

    public void insertNewUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    //"INSERT INTO user (username, email, password, id_avatar, id_skill) VALUES (?, ?, ?, ?, ?);"
                    "INSERT INTO user (username, email, password, id_skill) VALUES (?, ?, ?, ?);"
            );
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPwd());
            //statement.setInt(4, user.getIdAvatar());
            statement.setInt(4, user.getIdSkill());

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
    }


}
