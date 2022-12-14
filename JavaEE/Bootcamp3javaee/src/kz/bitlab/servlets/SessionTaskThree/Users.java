package kz.bitlab.servlets.SessionTaskThree;

public class Users {
    private Integer id;
   private String  user_name;
   private String password;
   private String fullname;

   public Users(){}

    public Users(Integer id, String user_name, String password, String fullname) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.fullname = fullname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
