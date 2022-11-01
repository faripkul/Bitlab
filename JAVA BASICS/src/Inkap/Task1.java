//package Inkap;
//
//public class Task1 {
//    public static void main(String[] args) {
//        Phone p1 = new Phone("Iphone", "11",200,256);
//        Phone p2 = new Phone("Iphone", "13PRO",6000,128);
//        Phone p3 = new Phone("Sumsung", "A30",100, 456);
//        Phone p4 = new Phone("Sumsung", "J50",600 , 516);
//        Phone p5 = new Phone("Sumsung", "A50",80000,616);
//        System.out.println(p1.getCategory());
//        System.out.println(p2.getCategory());
//        System.out.println(p3.getCategory());
//        System.out.println(p4.getCategory());
//        System.out.println(p5.getCategory());
//    }
//}
//
//class Phone {
//    private String name;
//    private String model;
//    private int price;
//    private int memory;
//
//    public Phone(String name, String model, int price, int memory) {
//        this.name = name;
//        this.model = model;
//        this.price = price;
//        this.memory = memory;
//    }
//
//    public Phone() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getMemory() {
//        return memory;
//    }
//
//    public void setMemory(int memory) {
//        this.memory = memory;
//    }
//
//    public String getCategory() {
//        if (price > 1000) {
//            return "ТОП";
//        }
//        if (price < 1000 && price > 500) {
//            return "MEDIUM";
//        }
//        if (price < 500) {
//            return "SIMPLE";
//        }
//        return null;
//    }
//}
//
//
//
//
//
