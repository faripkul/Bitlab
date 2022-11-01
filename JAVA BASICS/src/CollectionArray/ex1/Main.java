package CollectionArray.ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Players> players = new ArrayList<>();
        Players p1 = new Players("klsfg", 1617.0, 654);
        Players p2 = new Players("klsfg", 1617.15, 654);
        Players p3 = new Players("klsfg", 1617.75, 654);
        Players p4 = new Players("klsfg", 1617.96, 654);
        Players p5 = new Players("klsfg", 1617.15, 654);
        Players p6 = new Players("klsfg", 1617.36, 654);
        Players p7 = new Players("klsfg", 1617.19, 654);
        Players p8 = new Players("klsfg", 1617.41, 654);
        Players p9 = new Players("klsfg", 1617.95, 654);
        Players p10 = new Players("klsfg", 1617.14, 654);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        int sumAge = 0;
        int sumPrice = 0;
        for (int i = 0; i < players.size(); i++) {
            sumAge = sumAge + players.get(i).getAge();
            sumPrice = (int)(sumPrice + players.get(i).getPrice());
        }
        System.out.println(sumAge);
        System.out.println(sumPrice / 10);
    }
}


