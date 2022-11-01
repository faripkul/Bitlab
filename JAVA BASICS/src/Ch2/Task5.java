//package Ch2;
//import java.util.Scanner;
//
//public class Task5 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Student [] Students = new Student[100];
//        int index=0;
//        while(true) {
//            System.out.println("PRESS [1] TO ADD STUDENT");
//            System.out.println("PRESS [2] TO LIST STUDENT");
//            System.out.println("PRESS [0] TO EXIT");
//            int n = in.nextInt();
//            if (n == 1) {
//                System.out.println("Insert name?");
//                String name = in.next();
//                System.out.println("Insert surname?");
//                String surname = in.next();
//                System.out.println("Insert GPA?");
//                double gpa = in.nextDouble();
//                Student s1 = new Student(name, surname, gpa);
//                Students[index] = s1;
//                index++;
//
//            }
//            if (n == 2) {
//                for (int i=0; i<index;i++) {
//                    System.out.println(Students[i].getStudentData());
//                }
//            }
//            if (n == 0) {
//                break;
//            }
//        }
//    }
//}
//class Student {
//    String name;
//    String surname;
//    double gpa;
//
//    public Student () {
//        this.name = "No Name";
//        this.surname = "No Surname";
//        this.gpa = 0.0;
//    }
//
//    public Student (String name, String surname, double gpa) {
//        this.name = name;
//        this.surname = surname;
//        this.gpa = gpa;
//    }
//    public String getStudentData(){
//        return "name: "+name+", surname: "+surname+",gpa:" +gpa;
//    }
//}