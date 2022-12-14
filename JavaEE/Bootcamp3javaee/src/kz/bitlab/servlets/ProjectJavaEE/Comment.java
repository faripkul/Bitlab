package kz.bitlab.servlets.ProjectJavaEE;

import java.sql.Timestamp;

public class Comment {
   private Long id;
   private News news;
   private Polzovatel user;
   private String comment;
   private Timestamp postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Polzovatel getUser() {
        return user;
    }

    public void setUser(Polzovatel user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}
