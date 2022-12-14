package kz.bitlab.servlets.JDBStask1;

import javax.xml.transform.Result;
import java.sql.*;
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

    public static ArrayList<Students> getStudents() {
        ArrayList<Students> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT*FROM students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Students student = new Students();
                student.setId((long) resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));
                student.setCity(resultSet.getString("city"));
                students.add(student);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void addStudent(Students studentt) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students(name,surname,birthdate,city) " +
                    "VALUES(?,?,?,?)");
            statement.setString(1, studentt.getName());
            statement.setString(2, studentt.getSurname());
            statement.setString(3, studentt.getBirthdate());
            statement.setString(4, studentt.getCity());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Students getStudent(Long id) {
        Students studenttt = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM students " + "WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                studenttt = new Students();
                studenttt.setId(resultSet.getLong("id"));
                studenttt.setName(resultSet.getString("name"));
                studenttt.setSurname(resultSet.getString("surname"));
                studenttt.setBirthdate(resultSet.getString("birthdate"));
                studenttt.setCity(resultSet.getString("city"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studenttt;
    }

    public static void upDateStudent(Students student){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    " UPDATE students SET name=?, surname=?, birthdate=?, city=? " + "WHERE id=? ");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getBirthdate());
            statement.setString(4, student.getCity());
            statement.setLong(5,student.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Long id){

        try{
            PreparedStatement statement = connection.prepareStatement(
        "DELETE from students WHERE id = ?");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}



