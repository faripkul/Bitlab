//package Nasled;
//
//public class task2 {
//    public static void main(String[] args) {
//        Sportsman s1 = new Sportsman ("KJDhk", 25, "Shymkent");
//        Gymnast g1 = new Gymnast("Yusupova", 30, "Almaty", 180, 166,"dkmmk");
//        Footballer f1 = new Footballer ("fksjv", 254, "dkvkl;", "kdnd", "dkv" );
//        Swimmer sw1 = new Swimmer("d;ns", 26, "slkv", "Kjf",548);
//        s1.play();
//        g1.play();
//        f1.play();
//        sw1.play();
//    }
//}
//
//
//class Sportsman {
//    protected String fullname;
//    protected int age;
//    protected String country;
//
//    public Sportsman() {
//        this.fullname = "No Fullname";
//        this.age = 0;
//        this.country = "No country";
//    }
//
//    public Sportsman(String fullname, int age, String country) {
//        this.fullname = fullname;
//        this.age = age;
//        this.country = country;
//    }
//
//    public void play() {
//        System.out.println("Sportsman " + fullname + ", " + age + ", " + country  + " is playing");
//    }
//}
//
//class Gymnast extends Sportsman {
//    protected int height;
//    protected int weight;
//    protected String style;
//
//    public Gymnast() {
//        super();
//        this.height = 0;
//        this.weight = 0;
//        this.style = "No Style";
//
//    }
//
//    public Gymnast (String fullname, int age, String country, int height, int weight, String style) {
//        super(fullname,age,country);
//        this.height = height;
//        this.weight = weight;
//        this.style = style;
//    }
//
//    public void play() {
//        System.out.println("Sportsman " + fullname + ", " + age + ", " + country  +", " + height + ", " + weight  + ", " + style  +" is playing");
//    }
//}
//
//
//class Footballer extends Sportsman {
//    protected String position;
//    protected String club;
//
//    public Footballer() {
//        super();
//        this.position = "No Position";
//        this.club = "No Club";
//
//    }
//
//    public Footballer (String fullname, int age, String country,String position, String club) {
//        super(fullname,age,country);
//        this.position = position;
//        this.club = club;
//    }
//
//    public void play() {
//        System.out.println("Sportsman " + fullname + ", " + age + ", " + country  +", " + position + ", " + club  + " is playing");
//    }
//}
//
//class Swimmer extends Sportsman {
//    protected String style;
//    protected double recordTime;
//
//    public Swimmer() {
//        super();
//        this.style = "No Style";
//        this.recordTime = 0;
//
//    }
//
//    public Swimmer (String fullname, int age, String country,String style, double recordTime) {
//        super(fullname,age,country);
//        this.style = style;
//        this.recordTime = recordTime;
//    }
//
//    public void play() {
//        System.out.println("Sportsman " + fullname + ", " + age + ", " + country  +", " + style + ", " + recordTime  + " is playing");
//    }
//}