//package Abstract;
//
//public class Task2 {
//    public static void main(String[] args) {
//        SphereGold s1 = new SphereGold(16);
//        SphereGold s2 = new SphereGold (51);
//        SphereGold s3 = new SphereGold(16);
//
//        CubeGold c1 = new CubeGold(151);
//        CubeGold c2 = new CubeGold(14);
//        CubeGold c3 = new CubeGold(19);
//
//        GoldShape x[] = new GoldShape[6];
//        x[0] = s1;
//        x[1] = s2;
//        x[2] = s3;
//        x[3] = c1;
//        x[4] = c2;
//        x[5] = c3;
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i].getPrice());
//        }
//    }
//}
//
//
//abstract class GoldShape {
//    public abstract double getVolume();
//
//        public double getPrice() {
//            return getVolume() * 250 + 1200;
//        }
//    }
//
//
//class SphereGold extends GoldShape {
//    double radius;
//
//    public SphereGold() {
//        this.radius = 0;
//    }
//
//    public SphereGold(double radius) {
//        this.radius = radius;
//    }
//
//    public double getVolume() {
//        return (4/3)*3.14*(radius * radius*radius);
//    }
//}
//
//class CubeGold extends GoldShape {
//    double side;
//
//    public CubeGold() {
//        this.side = 0;
//    }
//
//    public CubeGold(double side) {
//        this.side = side;
//    }
//
//    public double getVolume() {
//        return side * side*side;
//    }
//}
//
