package kz.bitlab.servlets.ProjectJavaEE;

import java.sql.Timestamp;

public class News {
  private Long id;
  private String title;
  private String content;
  private Timestamp postDate;
  private Polzovatel user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public Polzovatel getUser() {
        return user;
    }

    public void setUser(Polzovatel user) {
        this.user = user;
    }
}
