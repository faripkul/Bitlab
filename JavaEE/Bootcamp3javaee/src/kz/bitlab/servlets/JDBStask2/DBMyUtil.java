package kz.bitlab.servlets.JDBStask2;

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
    public static ArrayList<Items2> getItems() {
        ArrayList<Items2> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT*FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Items2 item = new Items2();
                item.setId((long) resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }


    public static Users Sravnit(String email, String password){
        Users user = null;
        try{
            PreparedStatement statement = connection.prepareStatement( "" + "SELECT *FROM users " +
                    "WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user=new Users();
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}



