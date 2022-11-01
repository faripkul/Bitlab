//package Abstract;
//
//import java.util.Scanner;
//
//public class Task4 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        User[] users = new User[100];
//        int index = 0;
//        while (true) {
//            System.out.println("PRESS [1] TO ADD USER");
//            System.out.println("PRESS [2] TO LIST USERS");
//            System.out.println("PRESS [3] TO LIST USER BY INDEX");
//            System.out.println("PRESS [0] TO EXIT");
//            int x = in.nextInt();
//            if (x == 1) {
//                System.out.println("PRESS [1] TO ADD STUDENT");
//                System.out.println(" PRESS [2] TO ADD TEACHER");
//                int y = in.nextInt();
//                if (y == 1) {
//                    System.out.println("Login:");
//                    String Login = in.next();
//                    System.out.println("Password:");
//                    String Password = in.next();
//                    System.out.println("Name:");
//                    String Name = in.next();
//                    System.out.println("Surname:");
//                    String Surname = in.next();
//                    System.out.println("Group:");
//                    String Group = in.next();
//                    System.out.println("GPA:");
//                    Double GPA = in.nextDouble();
//                    users[index] = new Student(name, surname, gpa);
//                    index++;
//                }
//                if (y == 2) {
//                    System.out.println("Login:");
//                    String Login = in.next();
//                    System.out.println("Password:");
//                    String Password = in.next();
//                    System.out.println("Name:");
//                    String Name = in.next();
//                    System.out.println("Status:");
//                    String Status = in.next();
//                    Teacher first = new Teacher (login, password, nickName,status);
//
//                    while (true) {
//                    System.out.println("PRESS [0] TO FINISH ADDING SUBJECT");
//                    System.out.println("PRESS [1] TO ADD SUBJECT");
//                    int z = in.nextInt();
//                    if (z==0) {
//                        break;
//                    } if (z==1) {
//                        System.out.println("Subject:");
//                        String subject = in.next();
//                        first.addSubject(subject);
//                        }
//
//
//
//                    users[index] = new Nasled.Student(name, surname, gpa);
//                    index++;
//                }
//            }
//
//            if (x == 2) {
//                System.out.println("PRESS [1] TO LIST STUDENTS");
//                System.out.println("PRESS [2] TO LIST TEACHERS");
//                int y = in.nextInt();
//                if (y == 1) {
//                    for (int i = 0; i < index; i++) {
//                        if (users[i] instanceof Student) {
//                            System.out.println(users[i].getData());
//                        }
//                    }
//                } else if (y == 2) {
//                    for (int i = 0; i < index; i++) {
//                        if (users[i] instanceof Nasled.Staff) {
//                            System.out.println(users[i].getData());
//                        }
//                    }
//                    if (x == 3) {
//                        System.out.println("PRESS [3] TO LIST USER BY INDEX");
//                        for (int i = 0; i < index; i++) {
//                            if (users[i] instanceof Staff) {
//                                System.out.println(users[i].getData());
//                }
//            }
//
//            if (x == 0) {
//                break;
//            }
//        }
//    }
//class ERPSystem {
//    User[] memory = new User[1000];
//    int sizeOfUsers = 0;
//
//    void addUser(User u) {
//        memory[sizeOfUsers] = u;
//        sizeOfUsers++;
//    }
//
//    void printAllUsers() {
//        for (int i = 0; i < sizeOfUsers; i++)
//            System.out.println(memory[i].getUserData());
//    }
//}
//void printUser(int index) {
//if ()
//
//}
//
//}
//
//abstract class User {
//    int id;
//    String login;
//    String password;
//
//public User() {
//    this.id = 0;
//    this.login = "No Login";
//    this.password = "No Password";
//}
//
//public User(int id,String login, String password) {
//    this.id = id;
//    this.login = login;
//    this.password = password;
//}
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//public abstract String getUserData();;
//
// public void printUserData() {
//     System.out.println(getUserData());
// }
// }
//
//  class Student extends User {
//   String name;
//   String surname;
//   String group;
//   double gpa;
//
//   public Student() {
//     super ();
//     this.name = "No Name";
//     this.surname = "No Surame";
//     this.group = "No Group";
//     this.gpa = 0;
//   }
//    public Student(int id,String login, String password,String name, String surname,String group,double gpa) {
//      super (id, login,password);
//        this.name = name;
//        this.surname = surname;
//        this.group = group;
//        this.gpa = gpa;
//   }
//
//      public String getname() {
//          return name;
//      }
//
//      public void setName(String name) {
//          this.name = name;
//      }
//
//      public String getSurname() {
//          return surname;
//      }
//
//      public void setSurname(String surname) {
//          this.surname = surname;
//      }
//
//      public String getGroup() {
//          return group;
//      }
//
//      public void setGroup(String group) {
//          this.group = group;
//      }
//      public Double getGpa() {
//          return gpa;
//      }
//
//      public void setGpa(Double gpa) {
//          this.gpa = gpa;
//      }
//
//
//      public String getUserData() {
//      return ;
//                }
//            }
//
//    class Teacher extends User {
//     String nickName;
//     String status;
//     String subjects[] = new String[10];
//     int sizeOfSubjects = 0;
//
//
//      public Teacher(int id,String login, String password) {
//        super(id, login, password);
//        this.nickName = nickName;
//        this.status = status;
//
//        }
//
//        public String getNickName() {
//            return nickName;
//        }
//
//        public void setNickName(String nickName) {
//            this.nickName = nickName;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public int getSizeOfSubjects() {
//            return sizeOfSubjects;
//        }
//        public String getSubjects() {
//            return subjects[];
//
//        }
//
//        public String getUserData () {
//
//        }
//
//
//
//
