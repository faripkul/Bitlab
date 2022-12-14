package kz.bitlab.servlets.task3;

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
                    "root","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Tasks> getTasks(){
        ArrayList<Tasks>tasks=new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(""+"SELECT*FROM taskss");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Tasks tasks1=new Tasks();
                tasks1.setId((long) resultSet.getInt("id"));
                tasks1.setDescription(resultSet.getString("Наименование"));
                tasks1.setDeadlineDate(resultSet.getString("Крайний срок"));
                tasks.add(tasks1);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    public static void addTasks(Tasks task){
        try{
            PreparedStatement statement = connection.prepareStatement(""+"INSERT INTO taskss(Наименование, Крайний срок, Выполнено)"
                    +"VALUES(?,?,?)");
            statement.setString(1, task.getDescription());
            statement.setString(2, task.getDeadlineDate());
            statement.setString(3, "");
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}


