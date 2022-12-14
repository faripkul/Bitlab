package kz.bitlab.servlets.JDBStask4;

import kz.bitlab.servlets.JDBStask3.Students2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBMyUtil {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/fariza_db",
                    "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Items> getItems() {
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM items2 " + "WHERE id = ?");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setDescription(resultSet.getString("description"));
     //           item.setBrand(resultSet.getString("brand"));
                items.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }


    public static void addItems(Items itemm) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO item2(name,price,description,brand_id) " +
                    "VALUES(?,?,?,?)");
            statement.setString(1, itemm.getName());
            statement.setDouble(2, itemm.getPrice());
            statement.setString(3, itemm.getDescription());
            statement.setLong(4, itemm.getBrand().getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
