package kz.bitlab.servlets.SessionTaskOne;

public class ClientForm {
    private String name;
    private String surname;
    private String age;
    private String city;
    private String address;
    private String phone;
    private String univercity;
    private String faculty;
    private String group;

    public ClientForm(){}

    public ClientForm(String name, String surname, String age, String city, String address, String phone,
                      String univercity, String faculty, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.univercity = univercity;
        this.faculty = faculty;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
