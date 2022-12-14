package kz.bitlab.servlets.ProjectJavaEE;

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

    public static ArrayList<Polzovatel> getPolzovatels() {
        ArrayList<Polzovatel> polzovatels = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT*FROM avtoriz");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Polzovatel polzovatel = new Polzovatel();
                polzovatel.setId(resultSet.getInt("id"));
                polzovatel.setLogin(resultSet.getString("login"));
                polzovatel.setPassword(resultSet.getString("password"));
                polzovatels.add(polzovatel);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return polzovatels;
    }


    public static Polzovatel getPolzovatelByLogin(String login) {
        Polzovatel foundd = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM avtoriz " +
                    "WHERE login=? ");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                foundd = new Polzovatel();
                foundd.setLogin(login);
                foundd.setId(resultSet.getInt("id"));
                foundd.setPassword(resultSet.getString("password"));
                foundd.setName(resultSet.getString("name"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundd;
    }

    public static void addNews(News news) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (title, content, post_date, user_id) " +
                    "VALUES (?, ?, NOW(),?)");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setInt(3, news.getUser().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id,n.title,n.content,n.post_date, n.user_id,a.name, a.login " +
                    "FROM news n " +
                    "INNER JOIN avtoriz a ON a.id=n.user_id " +
                    "ORDER BY n.post_date DESC ");

            ResultSet resulset = statement.executeQuery();
            while (resulset.next()) {
                News n = new News();
                n.setId(resulset.getLong("id"));
                n.setTitle(resulset.getString("title"));
                n.setContent(resulset.getString("content"));
                n.setPostDate(resulset.getTimestamp("post_date"));

                Polzovatel p = new Polzovatel();
                p.setId(resulset.getInt("user_id"));
                p.setLogin(resulset.getString("login"));
                p.setName(resulset.getString("name"));

                n.setUser(p);
                news.add(n);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static News getNews(Long id) {
        News news = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id,n.title,n.content,n.post_date, n.user_id,a.name, a.login " +
                    "FROM news n " +
                    "INNER JOIN avtoriz a ON a.id = n.user_id " +
                    "WHERE n.id=?");

            statement.setLong(1, id);
            ResultSet resulset = statement.executeQuery();
            if (resulset.next()) {
                news = new News();
                news.setId(resulset.getLong("id"));
                news.setTitle(resulset.getString("title"));
                news.setContent(resulset.getString("content"));
                news.setPostDate(resulset.getTimestamp("post_date"));

                Polzovatel p = new Polzovatel();
                p.setId(resulset.getInt("user_id"));
                p.setLogin(resulset.getString("login"));
                p.setName(resulset.getString("name"));
                news.setUser(p);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addComment(Comment comment) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments(comment, user_id,news_id,post_date) " +
                    "VALUES (?,?,?,NOW())");

            statement.setString(1, comment.getComment());
            statement.setInt(2, comment.getUser().getId());
            statement.setLong(3, comment.getNews().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getComment(Long newsId) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.news_id,c.user_id, c.comment, c.post_date, a.name, a.login " +
                    "FROM comments c " +
                    "INNER JOIN avtoriz a ON a.id=c.user_id " +
                    "WHERE c.news_id = ? " +
                    "ORDER BY c.post_date DESC ");

            statement.setLong(1, newsId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
             Comment comment = new Comment();
             comment.setId(resultSet.getLong("id"));
             comment.setPostDate(resultSet.getTimestamp("post_date"));
             comment.setComment(resultSet.getString("comment"));

             News news = new News();
             news.setId(resultSet.getLong("news_id"));
             comment.setNews(news);

             Polzovatel user = new Polzovatel();
             user.setLogin(resultSet.getString("login"));
             user.setName(resultSet.getString("name"));
             user.setId(resultSet.getInt("user_id"));

             comment.setUser(user);
             comments.add(comment);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public static void addNewUser(Polzovatel user){
        try{

           PreparedStatement statement =
                   connection.prepareStatement("INSERT INTO avtoriz(login, password,name) " +
                           "VALUES (?,?,?)");

           statement.setString(1,user.getLogin());
           statement.setString(2,user.getPassword());
           statement.setString(3,user.getName());

           statement.executeUpdate();
           statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

 public static void changePassword(Polzovatel user){
    try {
      PreparedStatement statement = connection.prepareStatement(""+
              "UPDATE avtoriz SET password=? WHERE id=?");

      statement.setString(1, user.getPassword());
      statement.setLong(2,user.getId());

      statement.executeUpdate();
      statement.close();

    }catch (Exception e){
        e.printStackTrace();
    }

 }




}






