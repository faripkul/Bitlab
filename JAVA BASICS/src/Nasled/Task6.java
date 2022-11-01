//package Nasled;
//
//import java.util.Scanner;
//
//public class Task6 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        User[] users = new User[100];
//        int index = 0;
//        while (true) {
//            System.out.println("PRESS [1] ADD USER");
//            System.out.println("PRESS [2] TO LIST USERS");
//            System.out.println("PRESS [0] TO EXIT");
//            int x = in.nextInt();
//            if (x == 1) {
//                System.out.println("PRESS [1] TO ADD STUDENT");
//                System.out.println("PRESS [2] TO ADD STAFF ");
//                int y = in.nextInt();
//                if (y == 1) {
//                    System.out.println("Insert name?");
//                    String name = in.next();
//                    System.out.println("Insert surname?");
//                    String surname = in.next();
//                    System.out.println("Insert GPA?");
//                    Double gpa = in.nextDouble();
//                    users[index] = new Student(name, surname, gpa);
//                    index++;
//                }
//                if (y == 2) {
//                    System.out.println("Insert name?");
//                    String name = in.next();
//                    System.out.println("Insert surname?");
//                    String surname = in.next();
//                    System.out.println("Insert AGE?");
//                    int age = in.nextInt();
//                    users[index] = new Staff(name, surname, age);
//                    index++;
//                }
//            }
//
//            if (x == 2) {
//                System.out.println("PRESS [1] TO LIST STUDENT");
//                System.out.println("PRESS [2] TO LIST STAFF ");
//                int y = in.nextInt();
//                if (y == 1) {
//                    for (int i = 0; i < index; i++) {
//                        if (users[i] instanceof Student) {
//                            System.out.println(users[i].getData());
//                        }
//                    }
//                } else if (y == 2) {
//                    for (int i = 0; i < index; i++) {
//                        if (users[i] instanceof Staff) {
//                            System.out.println(users[i].getData());
//                        }
//                    }
//                }
//            }
//
//            if (x == 0) {
//                break;
//            }
//        }
//    }
//}
//
//
//class User {
//    protected String name;
//    protected String surname;
//
//    public User() {
//        this.name = "No Name";
//        this.surname = "No Surname";
//
//    }
//
//    public User(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    public String getData() {
//        return "name:" + name + ", surname:" + surname;
//    }
//}
//
//class Student extends User {
//    protected double gpa;
//
//    public Student() {
//        super();
//        this.gpa = 0;
//    }
//
//    public Student(String name, String surname, double gpa) {
//        super(name, surname);
//        this.gpa = gpa;
//    }
//
//    public String getData() {
//        return "name:" + name + ", surname:" + surname + ", gpa:" + gpa;
//    }
//}
//
//
//class Staff extends User {
//    protected int age;
//
//    public Staff() {
//        super();
//        this.age = 0;
//    }
//
//    public Staff(String name, String surname, int age) {
//        super(name, surname);
//        this.age = age;
//    }
//
//    public String getData() {
//        return "name:" + name + ", surname:" + surname + ", age:" + age;
//    }
//}
//
//
//
//
//
//
//
//
//
//
