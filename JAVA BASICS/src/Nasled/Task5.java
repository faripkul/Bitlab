//package Nasled;
//
//public class Task5 {
//    public static void main(String[] args) {
//        User [] x = new User[15];
//        x [0] = new User (245, "klfgjo", "kjdfnb", "dkjfng", "dfkjg");
//        x [1] = new User (154, "klfgjo", "kjdfnb", "dkjfng", "dfkjg");
//        x [2] = new User (658, "klfgjo", "kjdfnb", "dkjfng", "dfkjg");
//        x [3] = new User (198, "klfgjo", "kjdfnb", "dkjfng", "dfkjg");
//        x [4] = new User (654, "klfgjo", "kjdfnb", "dkjfng", "dfkjg");
//        x [5] = new Staff (63, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [6] = new Staff (89, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.4,  1541);
//        x [7] = new Staff (14, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.7,  1541);
//        x [8] = new Staff (35, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [9] = new Staff (82, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [10] = new Student (2, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [11] = new Student (75, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [12] = new Student (762, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [13] = new Student (752, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        x [14] = new Student (12, "klfgjo", "kjdfnb", "dkjfng", "dfkjg", 264.0,  1541);
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i].getData());
//        }
//    }
//}
//
//
//
//
//class User {
//    protected int id;
//    protected String login;
//    protected String password;
//    protected String name;
//    protected String surname;
//
//    public User () {
//     this.id = 0;
//     this.login = "No Login";
//     this.password = "No Password";
//     this.name = "No Name";
//     this.surname = "No Surname";
//    }
//
//    public User (int id, String login, String password, String name, String surname) {
//        this.id = id;
//        this.login = login;
//        this.password = password;
//        this.name = name;
//        this.surname = surname;
//    }
//    public String getData () {
//        return "id:" + id + ", login:" + login + ", password:" + password+ ", name:" + name+ ", surname:" + surname;
//
//    }
//}
//
//class Staff extends User {
//    private double salary;
//    private String subjects[] = new String[100];
//    private int indexOfSubject = 0;
//
//    public Staff(int id, String login, String password, String name, String surname, double salary, int indexOfSubject) {
//        super(id, login, password, name, surname);
//        this.salary = salary;
//        this.subjects = subjects;
//        this.indexOfSubject = indexOfSubject;
//    }
//
//    public Staff() {
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    public int getIndexOfSubject() {
//        return indexOfSubject;
//    }
//
//    public void setIndexOfSubject(int indexOfSubject) {
//        this.indexOfSubject = indexOfSubject;
//    }
//
//    public void addSubject(String subject) {
//        subjects[indexOfSubject] = subject;
//        indexOfSubject = indexOfSubject + 1;
//    }
//
//    public void getData() {
//        System.out.println("id:" + id + ", login:" + login + ", password:" + password + ", name:" + name +
//                ", surname:" + surname + ", salary:" + salary + ", indexOfSubject:" + indexOfSubject);
//        for (int i = 0; i < indexOfSubject; i++) {
//            System.out.println(subjects[i]);
//        }
//    }
//}
//
//
//
//
//
//class Student extends User {
//    private double gpa;
//    private String courses[] = new String[100];
//    private int indexOfCourses = 0;
//
//    public Student(int id, String login, String password, String name, String surname, double gpa, int indexOfCourses) {
//        super(id, login, password, name, surname);
//        this.gpa = gpa;
//        this.courses = courses;
//        this.indexOfCourses = indexOfCourses;
//    }
//
//    public Student() {
//    }
//
//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }
//
//    public int getIndexOfCourses() {
//        return indexOfCourses;
//    }
//
//    public void setIndexOfCourses(int indexOfCourses) {
//        this.indexOfCourses = indexOfCourses;
//    }
//
//    public String getData() {
//        return "id:" + id + ", login:" + login + ", password:" + password + ", name:" +
//                name + ", surname:" + surname + ", gpa:" + gpa + ", indexOfCourses:" + indexOfCourses;
//
//        for (int i = 0; i < courses.length; i++) {
//            System.out.println(courses[i]);
//        }
//    }
//
//    public String addCourse(String course) {
//        courses[indexOfCourses] = course;
//        indexOfCourses = indexOfCourses + 1;
//    }
//}
//
