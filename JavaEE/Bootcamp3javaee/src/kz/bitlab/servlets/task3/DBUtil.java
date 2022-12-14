//package kz.bitlab.servlets.task3;
//
//import com.sun.jdi.connect.spi.Connection;
//import org.postgresql.Driver;
//
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//public class DBUtil {
//    private static Connection connection;
//
//    static {
//        Class.forName("org.postgresql.Driver");
//        connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/fariza_db",
//                "root","root");
//
//
//        try {
//        } catch (Exception e) {
//         e.printStackTrace();
//
//        }
//    }
//    public static ArrayList<Tasks>getTasks(){
//        ArrayList<Tasks>tasks=new ArrayList<>();
//        try{
//            PreparedStatement statement = connection.prepareStatement(""+"SELECT*FROM items");
//            ResultSet resultSet=statement.executeQuery();
//            while (resultSet.next()){
//                Tasks tasks1=new Tasks();
//                tasks1.setId((long) resultSet.getInt("id"));
//                tasks1.setDescription(resultSet.getString("Наименование"));
//                tasks1.setDeadlineDate(resultSet.getString("Крайний срок"));
//                tasks.add(tasks1);
//            }
//            statement.close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return tasks;
//    }
//
//    public static void addTasks(Tasks task){
//     try{
//         PreparedStatement statement = connection.prepareStatement(""+"INSERT INTO tasks(name, )" +"VALUES(?,?,?)");
//         statement.setString();
//
//     }catch (Exception e){
//         e.printStackTrace();
//     }
//
//    }
//
//
//}
