package kz.bitlab.servlets.SessionTaskThree;

import kz.bitlab.servlets.JDBStask2.Items2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBMyUtil {
    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/fariza_db",
                    "root", "");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Users> getUsers() {
        ArrayList<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT*FROM auth");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("user_password"));
                users.add(user);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    public static Users getUserByEmail(String email){
        Users found = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM auth " +
                    "WHERE email=? ");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                found = new Users();
                found.setUser_name(email);
                found.setId(resultSet.getInt("id"));
                found.setPassword(resultSet.getString("password"));
                found.setFullname(resultSet.getString("fullname"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return found;
    }

}
