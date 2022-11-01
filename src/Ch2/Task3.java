//package Ch2;
//
//public class Task3 {
//    public static void main(String[] args) {
//        Student[] Students = new Student[5];
//        Students[0] = new Student();
//        Students[1] = new Student(466, "Arman", "Lulu", 80.6);
//        Students[2] = new Student(964, "Bib", "Tom", 90.0);
//        Students[3] = new Student(122, "Indira", "Shake", 100.1);
//        Students[4] = new Student(756, "Marjan", "Take", 70.1);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Students[i].getStudentData());
//        }
//    }
//}
//class Student {
//    int id;
//    String name;
//    String surname;
//    double gpa;
//
//public Student () {
//    this.id = 0;
//    this.name = "No Name";
//    this.surname = "No Surname";
//    this.gpa = 0;
//}
//
//public Student (int id, String name, String surname, double gpa) {
//    this.id = id;
//    this.name = name;
//    this.surname = surname;
//    this.gpa = gpa;
//}
//    public String getStudentData(){
//        return "ID : "+id+", name: "+name+", surname: "+surname+",gpa:" +gpa;
//    }
//}