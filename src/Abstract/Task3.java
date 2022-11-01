//package Abstract;
//
//public class Task3 {
//    public static void main(String[] args) {
//        RenaultEnigine r1 = new RenaultEnigine(55, 1515, 151,55 );
//        RenaultEnigine r2 = new RenaultEnigine(55, 1515, 151,55 );
//        RenaultEnigine r3 = new RenaultEnigine(55, 1515, 151,55 );
//        RenaultEnigine r4 = new RenaultEnigine(55, 1515, 151,55 );
//        RenaultEnigine r5 = new RenaultEnigine(55, 1515, 151,55 );
//        FerrariEngine f1 = new FerrariEngine (51,651,51);
//        FerrariEngine f2 = new FerrariEngine (51,651,51);
//        FerrariEngine f3 = new FerrariEngine (51,651,51);
//        FerrariEngine f4 = new FerrariEngine (51,651,51);
//        FerrariEngine f5 = new FerrariEngine (51,651,51);
//        Engine x[] = new Engine[10];
//        x[0] = r1;
//        x[1] = r2;
//        x[2] = r3;
//        x[3] = r4;
//        x[4] = r5;
//        x[5] = f1;
//        x[6] = f2;
//        x[7] = f3;
//        x[8] = f4;
//        x[9] = f5;
//
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i].getMaxSpeed());
//        }
//    }
//}
//
//
//abstract class Engine {
// double engineVolume;
// int cylinderAmount;
// double engineWeight;
//
//    public Engine() {
//        this.engineVolume = 0;
//        this.cylinderAmount = 0;
//        this.engineWeight = 0;
//    }
//
//    public Engine(double engineVolume, int cylinderAmount, double engineWeight) {
//        this.engineVolume = engineVolume;
//        this.cylinderAmount = cylinderAmount;
//        this.engineWeight = engineWeight;
//    }
//
//    public double getEngineVolume() {
//        return engineVolume;
//    }
//
//    public void setEngineVolume(double engineVolume) {
//        this.engineVolume = engineVolume;
//    }
//
//    public int getCylinderAmount() {
//        return cylinderAmount;
//    }
//
//    public void setCylinderAmount(int cylinderAmount) {
//        this.cylinderAmount = cylinderAmount;
//    }
//
//    public double getEngineWeight() {
//        return engineWeight;
//    }
//
//    public void setEngineWeight(double engineWeight) {
//        this.engineWeight = engineWeight;
//    }
//
//    public abstract double efficiency();
//    public abstract double throttleEnergy();
//    public abstract double breakEnergy();
//
//    public double getMaxSpeed() {
//        return (throttleEnergy()-breakEnergy())*efficiency();
//    }
//}
//
//
//class FerrariEngine extends Engine {
//    public FerrariEngine() {
//}
//
//    public FerrariEngine(double engineVolume, int cylinderAmount, double engineWeight) {
//        super(engineVolume, cylinderAmount,engineWeight);
//    }
//    public double efficiency() {
//    return 0.25;
//}
//    public double throttleEnergy() {
//    return engineVolume*cylinderAmount*100;
//    }
//    public double breakEnergy() {
//    return engineWeight*2;
//    }
//}
//
//class RenaultEnigine extends Engine {
//    public double extraTurboEnergy;
//
//    public RenaultEnigine() {
//        super();
//        this.extraTurboEnergy = 0;
//    }
//
//    public RenaultEnigine(double engineVolume, int cylinderAmount, double engineWeight, double extraTurboEnergy) {
//        super(engineVolume, cylinderAmount,engineWeight);
//        this.extraTurboEnergy = extraTurboEnergy;
//    }
//
//    public double efficiency() {
//        return  0.27;
//    }
//    public double throttleEnergy() {
//        return engineVolume*cylinderAmount*110 + extraTurboEnergy;
//    }
//    public double breakEnergy() {
//        return engineWeight*2.1;
//    }
//}
//
//
