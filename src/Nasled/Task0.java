//package Nasled;
//
//public class Task0 {
//    public static void main(String[] args) {
//        Car c1 = new Car ("Lexus", "A50", 200, 2022, 216);
//        Toyota t1 = new Toyota("Toyota", "djfk", 2651, 2021, 166,"dkmmk");
//        Mercedes m1 = new Mercedes ("fslkg", "dklsf", 6554, 5444, 2,"ghj");
//            c1.ride();
//            t1.ride();
//            m1.ride();
//        }
//    }
//
//
//
//class Car {
//    protected String name;
//    protected String model;
//    protected int maxSpeed;
//    protected int year;
//    protected double volume;
//
//    public Car() {
//        this.name = "No Name";
//        this.model = "No Name";
//        this.maxSpeed = 0;
//        this.year = 0;
//        this.volume = 0.0;
//    }
//
//    public Car(String name, String model, int maxSpeed, int year, int volume) {
//        this.name = name;
//        this.model = model;
//        this.maxSpeed = maxSpeed;
//        this.year = year;
//        this.volume = volume;
//    }
//
//    public void ride() {
//        System.out.println("Car " + name + ", " + model + ", " + maxSpeed + ", " + year + ", " + volume + " is riding");
//    }
//}
//
//class Toyota extends Car {
//    protected String manufacture;
//
//    public Toyota() {
//        super();
//        this.manufacture = "No Manufacture";
//    }
//
//    public Toyota(String name, String model, int maxSpeed, int year, int volume, String manufacture) {
//        super(name, model, maxSpeed, year, volume);
//        this.manufacture = manufacture;
//    }
//
//    public void ride() {
//        System.out.println("Car " + name + ", " + model + ", " + maxSpeed + ", " + year + ", " + volume + ", " + manufacture + " is riding");
//    }
//}
//
//class Mercedes extends Car {
//
//    protected String classType;
//
//    public Mercedes() {
//        super();
//        this.classType = "No classtype";
//    }
//
//    public Mercedes(String name, String model, int maxSpeed, int year, int volume, String classType) {
//        super(name, model, maxSpeed, year, volume);
//        this.classType = classType;
//    }
//    public void ride() {
//        System.out.println("Car " + name + ", " + model + ", " + maxSpeed + ", " + year + ", " + volume + ", " + classType + " is riding");
//    }
//}
//
//
