package uz.nammqi.tg_bot_latest.service;

import uz.nammqi.tg_bot_latest.entity.Districts;
import uz.nammqi.tg_bot_latest.entity.Regions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void insertVillage(Long chatId, String village) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set village=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, village);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertDistrict(Long chatId, String district) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set district=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, district);
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

    public void insertYear(Long chatId, String year) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            if (year.startsWith("null"))
            year=year.substring(4);
            String sql = "update application set yil=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            int dbYil=Integer.parseInt(year);
            preparedStatement.setInt(1, dbYil);//mana wu yerda muammo kelib chiqyapti yilni yoza olmayapti
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getYear(Long chatId) {
        String year = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql1 = "select yil from application where chat_id="+chatId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                year = resultSet.getString("yil");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return year;
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


    //IMPORT DATA FROM DB



    public List<String> getRegions() {
        List<String> regionsString = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql = "select name_uz from regions";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nameUz = resultSet.getString("name_uz");
                regionsString.add(nameUz);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsString;
    }


    public List<String> getDistricts(String region) {
        List<String> districtsList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql1 = "select id from regions where name_uz=" +"'"+ region+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            Integer regionId = 0;
            while (resultSet.next()) {
                regionId = resultSet.getInt("id");
            }
            String sql2 = "select name_uz from districts where region_id=" + regionId;
            ResultSet resultSet2 = statement.executeQuery(sql2);
            while (resultSet2.next()) {
                String districtName = resultSet2.getString("name_uz");
                districtsList.add(districtName);
            }

            resultSet.close();
            resultSet2.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districtsList;
    }
    public List<String> getVillages(String district) {
        List<String> villagesList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql1 = "select id from districts where name_uz=" +"'"+ district+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            Integer districtId = 0;
            while (resultSet.next()) {
                districtId = resultSet.getInt("id");
            }
            String sql2 = "select name_uz from villages where district_id=" + districtId;
            ResultSet resultSet2 = statement.executeQuery(sql2);
            while (resultSet2.next()) {
                String villageName = resultSet2.getString("name_uz");
                villagesList.add(villageName);
            }
            resultSet.close();
            resultSet2.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return villagesList;
    }
    public Integer getReplyId(Long chatId) {
        Integer replyId = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql1 = "select replyId from application where chatId="+chatId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                replyId = resultSet.getInt("replyId");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyId;
    }



    public void insertReplyId(Long chatId, Integer replyId) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set replyId=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, replyId);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertMessageId(Long chatId, Integer messageId) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");
            String sql = "update application set message_id=? where chat_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, messageId);
            preparedStatement.setLong(2, chatId);
            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Integer getMessageId(Long chatId) {
        Integer messageId = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bot_db", "postgres", "root456");

            String sql1 = "select message_id from application where chat_id="+chatId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                messageId = resultSet.getInt("message_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageId;
    }


}
