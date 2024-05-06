package uz.nammqi.tg_bot_latest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {

    public void insertUser(Long chatId, String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql = "insert into application(chat_id,username) values(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, chatId);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMurojaatTuri(Long chatId, String murojaatTuri) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set murojaat_turi=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, murojaatTuri);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertFullName(Long chatId, String fullName) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set full_name=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, fullName);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertHudud(Long chatId, String hudud) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set hudud=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, hudud);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertPhone(Long chatId, String phone) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set tel_nomer=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, phone);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertGender(Long chatId, String gender) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set jins=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, gender);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertYear(Long chatId, int year) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set yil=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, year);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMonth(Long chatId, String month) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set oy=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, month);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertDay(Long chatId, int day) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set kun=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, day);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMaqom(Long chatId, String maqom) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set maqom=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, maqom);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertSendingPerson(Long chatId, String sendingPerson) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set qabul=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, sendingPerson);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMurojaatMatni(Long chatId, String murojaatMatni) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set murojaat_matni=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, murojaatMatni);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
