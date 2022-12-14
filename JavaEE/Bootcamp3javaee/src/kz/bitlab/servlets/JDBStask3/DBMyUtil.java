package kz.bitlab.servlets.JDBStask3;

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

    static ArrayList<Students2> getStudentz2() {
        ArrayList<Students2> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM students2 " + "WHERE id = ?");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Students2 student = new Students2();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));
//                student.setCity(resultSet.getString("city"));
                students.add(student);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    static ArrayList<Cities> getCities() {
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM city");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cities city = new Cities();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));
                cities.add(city);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }


    public static void addStudentz(Students2 studentt) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students2(name,surname,birthdate,city_id) " +
                    "VALUES(?,?,?,?)");
            statement.setString(1, studentt.getName());
            statement.setString(2, studentt.getSurname());
            statement.setString(3, studentt.getBirthdate());
            statement.setLong(4, studentt.getCity().getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Students2 getStudent2(Long id) {
        Students2 studenttt = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT st.*, ct.name AS cityName, ct.code " +
                    "FROM  students2 st " +
                    "INNER JOIN city ct ON st.city_id = ct.id " +
                    "WHERE st.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                studenttt = new Students2();
                studenttt.setId(resultSet.getLong("id"));
                studenttt.setName(resultSet.getString("name"));
                studenttt.setSurname(resultSet.getString("surname"));
                studenttt.setBirthdate(resultSet.getString("birthdate"));

                Cities city = new Cities();
                city.setId((long) resultSet.getInt("city_id"));
                city.setName(resultSet.getString("cityName"));
                city.setCode(resultSet.getString("code"));

                studenttt.setCity(city);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studenttt;
    }

    public static void upDateStudentt(Students2 student) {

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    " UPDATE students2 SET name=?, surname=?, birthdate=?, city_id=? " + "WHERE id=? ");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getBirthdate());
            statement.setLong (4, student.getCity().getId());
            statement.setLong(5, student.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Long id) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE from students WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void addCitiez(Cities gorod) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO city(name, code) " +
                    "VALUES(?,?)");
            statement.setString(1, gorod.getName());
            statement.setString(2, gorod.getCode());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void upDateCity(Cities ccity) {

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    " UPDATE city SET name=?, code=? " + "WHERE id=? ");
            statement.setString(1, ccity.getName());
            statement.setString(2, ccity.getCode());
            statement.setLong(3, ccity.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cities getCity(Long id) {
        Cities ccity = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM city " + "WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ccity = new Cities();
                ccity.setId(resultSet.getLong("id"));
                ccity.setName(resultSet.getString("name"));
                ccity.setCode(resultSet.getString("code"));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ccity;
    }


    static ArrayList<Students2> getStudentz() {
        ArrayList<Students2> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT st.*, ct.name AS cityName, ct.code " +
                    "FROM  students2 st " +
                    "INNER JOIN city ct ON st.city_id = ct.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Students2 student = new Students2();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));

                Cities city = new Cities();
                city.setId((long) resultSet.getInt("city_id"));
                city.setName(resultSet.getString("cityName"));
                city.setCode(resultSet.getString("code"));

                student.setCity(city);

                students.add(student);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static ArrayList<Cities> getCityess() {
        ArrayList<Cities> cities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM city ORDER BY name ASC");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cities citi = new Cities();
                citi.setId((long) resultSet.getInt("id"));
                citi.setName(resultSet.getString("name"));
                citi.setCode(resultSet.getString("code"));

                cities.add(citi);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static Cities getCiti(Long id) {
        Cities citi = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM city WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                citi = new Cities();
                citi.setId((long) resultSet.getInt("id"));
                citi.setName(resultSet.getString("name"));
                citi.setCode(resultSet.getString("code"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citi;
    }
}







