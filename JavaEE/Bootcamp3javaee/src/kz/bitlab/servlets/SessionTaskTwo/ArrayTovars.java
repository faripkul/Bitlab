package kz.bitlab.servlets.SessionTaskTwo;

import java.util.ArrayList;

public class ArrayTovars {
    private static ArrayList<Tovars> tovary = new ArrayList<>();
    private static int id = 7;


    static {
        tovary.add(new Tovars(1, "Adidas 50L", "500$"));
        tovary.add(new Tovars(2, "Nike 11", "100$"));
        tovary.add(new Tovars(3, "Puma 79X", "90$"));
        tovary.add(new Tovars(4, "Columbia 8S", "600$"));
        tovary.add(new Tovars(5, "Asics", "100$"));
        tovary.add(new Tovars(6, "Nike 555", "500$"));
    }
    public static ArrayList<Tovars> getTovars() {
        return tovary;
    }

    public static Tovars getTovarById(int id) {
        Tovars ttt = null;
        for(Tovars tovr: tovary){
            if(ttt.getId()==id) {
                ttt=tovr;
            }
        }
        return ttt;
    }
}
