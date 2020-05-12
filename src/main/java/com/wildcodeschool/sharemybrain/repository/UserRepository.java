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

    public boolean findUsernamePsw(String psw, String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE  password = ? AND username = ?;"
            );
            statement.setString(1, psw);
            statement.setString(2, username);
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
                    "INSERT INTO user (username, email, password, id_avatar, id_skill) VALUES (?, ?, ?, ?, ?);"
            );
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPwd());
            statement.setInt(4, user.getIdAvatar());
            statement.setInt(5, user.getIdSkill());

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

    public int findSkill(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT id_skill FROM user WHERE username = ?;"
            );
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idSkill = resultSet.getInt("id_skill");
                return idSkill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }
    public int findUserId(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT id_user FROM user WHERE username = ?;"
            );
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                return idUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    public int findAvatar(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT id_avatar FROM user WHERE username = ?;"
            );
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idSkill = resultSet.getInt("id_avatar");
                return idSkill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    public int findAvatarById(int idUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT id_avatar FROM user WHERE id_user = ?;"
            );
            statement.setInt(1, idUser);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idSkill = resultSet.getInt("id_avatar");
                return idSkill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    public int findUserName(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT username FROM user WHERE id_user = ?;"
            );
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                return idUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

/*    public int findAvatarUsernameAndSkill(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT user.username, avatar.url, skill.name FROM user JOIN avatar ON avatar.id_avatar = user.id_avatar JOIN skill ON skill.id_skill = user.id_skill WHERE id_user = ?;"
            );
            statement.setInt( 1, userId);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                int idUser = resultSet.getInt ("id_user");
                return idUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }*/

}
