//package Ch2;
//
//public class Task4 {
//    public static void main(String[] args) {
//        Student [] Students = new Student[10];
//        Students[0] = new Student();
//        Students[1] = new Student(466, "Arman", "Lulu", 80);
//        Students[2] = new Student(964, "Bib", "Tom", 90);
//        Students[3] = new Student(122, "Indira", "Shake", 100);
//        Students[4] = new Student(756, "Marjan", "Take", 70);
//        Students[5] = new Student(253, "Aidar", "Bimatov", 120);
//        Students[6] = new Student(728, "Lola", "Bon", 99);
//        Students[7] = new Student(739, "Mimi", "X", 48);
//        Students[8] = new Student(158, "Pedro", "Don", 69);
//        Students[9] = new Student(258, "Mamba", "Li", 75);
//        for (int i=0; i<10; i++) {
//            System.out.println(Students[i].getStudentData());
//        }
//        System.out.println(topStudent(Students));
//    }
//        static Student topStudent(Student[]Students) {
//            Student s = Students[0];
//            for (int i=0; i<10; i++) {
//                if (Students[i].gpa>s.gpa) {
//                    s = Students[i];
//                }
//            }
//            return s;
//        }
//
//}
//class Student {
//    int id;
//    String name;
//    String surname;
//    double gpa;
//
//    public Student () {
//        this.id = 0;
//        this.name = "No Name";
//        this.surname = "No Surname";
//        this.gpa = 0;
//    }
//
//    public Student (int id, String name, String surname, double gpa) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.gpa = gpa;
//    }
//    public String getStudentData(){
//        return "ID : "+id+", name: "+name+", surname: "+surname+",gpa:" +gpa;
//    }
//}
//
//
//
