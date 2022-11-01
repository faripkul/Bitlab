package Liyambda2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CheredovanieChisel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            integers.add(in.nextInt());
        }
        long count = IntStream
                .range(1, z)
                .filter(n -> (integers.indexOf(z) > 0 && integers.indexOf(z + 1) > 0)
                        || (integers.indexOf(z) < 0 && integers.indexOf(z + 1) < 0))
                .count();
        if (count == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}





