//package Nasled;
//
//public class Task4 {
//    public static void main(String[] args) {
//        Sportsman [] y = new Sportsman[3];
//        y[0] = new Gymnast("Yusupova", 30, "Almaty", 180, 166, "dkmmk");
//        y[1] = new Footballer("fksjv", 254, "dkvkl;", "kdnd", "dkv");
//        y[2] = new Swimmer("d;ns", 26, "slkv", "Kjf", 548);
//        OlympicGames x = new OlympicGames("New York", 2022, y);
//        x.play();
//    }
//}
//
//class OlympicGames {
//    protected String city;
//    protected int year;
//    protected Sportsman sportsmansList[];
//
//    public OlympicGames() {
//        this.city = "No City";
//        this.year = 0;
//        this.sportsmansList = null;
//    }
//
//    public OlympicGames(String city, int year, Sportsman[] sportsmansList) {
//        this.city = city;
//        this.year = year;
//        this.sportsmansList = sportsmansList;
//    }
//
//    public void play() {
//        System.out.println("Sportsmans " + city + ", " + year + ":");
//
//        for (int i = 0; i < sportsmansList.length; i++) {
//            sportsmansList[i].play();
//        }
//    }
//}
//
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
//
