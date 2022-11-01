//package Abstract;
//
//public class Task1 {
//    public static void main(String[] args) {
//        Chocolate Snickers = new Chocolate("dlfkj", 5);
//        Chocolate Twix = new Chocolate("plxap", 48);
//
//        Burger BurgerKing = new Burger("kfgj", 154, 265);
//        Burger McDonalds = new Burger("kfgj", 154, 265);
//
//        Coke CocaCola = new Coke("skdjn", 256, 516);
//        Coke FuseTea = new FuseTea("skdjn", 256, 516);
//
//        Food tovar[] = new Food[6];
//        tovar[0] = Snickers;
//        tovar[1] = Twix;
//        tovar[2] = BurgerKing;
//        tovar[3] = McDonalds;
//        tovar[4] = CocaCola;
//        tovar[5] = FuseTea;
//        for (int i = 0; i < tovar.length; i++) {
//            tovar[i].getCalories();
//        }
//    }
//}
//
//
// abstract class Food {
//    String name;
//
//    public Food() {
//        this.name = "No Name";
//    }
//
//    public Food(String name) {
//        this.name = name;
//    }
//
//    public abstract double getCalories();
//
//    public void printCalories() {
//        System.out.println("MY CALORIES IS : " + getCalories());
//    }
//}
//
//        class Chocolate extends Food {
//            int weight;
//
//            public Chocolate() {
//                super ();
//                this.weight = 0;
//            }
//
//            public Chocolate(String name, int weight) {
//                super (name);
//                this.weight = weight;
//            }
//
//            public double getCalories() {
//                return weight * 740;
//            }
//        }
//
//         class Burger extends Food {
//            int meatAmount;
//            int meatType;
//
//            public Burger() {
//                super ();
//                this.meatAmount = 0;
//                this.meatType = 0;
//            }
//
//            public Burger(String name, int meatAmount, int meatType) {
//                super(name);
//                this.meatAmount = meatAmount;
//                this.meatType = meatType;
//            }
//
//            public double getCalories() {
//                while (true) {
//                    if (meatType == 1) {
//                        return meatAmount * 840;
//                    }
//                    if (meatType == 2) {
//                        return meatAmount * 560;
//                    }
//                    if (meatType != 1 || meatType != 2) {
//                        return 0;
//                    }
//                }
//            }
//        }
//
//         class Coke extends Food {
//            double volumeLiters;
//            boolean isSparkling;;
//
//            public Coke() {
//                this.volumeLiters = 0;
//                this.isSparkling = 0;
//            }
//
//            public Coke(double volumeLiters, boolean isSparkling) {
//                this.volumeLiters = volumeLiters;
//                this.isSparkling = isSparkling;
//            }
//
//            public double getCalories() {
//                if (isSparkling = true) {
//                    return  volumeLiters * 400;
//            }
//                else {
//                    return volumeLiters * 100;
//                }
//            }
//        }
