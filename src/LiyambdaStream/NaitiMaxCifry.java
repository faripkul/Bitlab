package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;

public class NaitiMaxCifry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 2; i < z; i++)
            integers.add(in.nextInt());

        long max = integers.stream()
                .max(Integer::compareTo)
                .get();
        integers.stream()
                .filter(n->integers.indexOf(max)==integers.indexOf(n));
        System.out.print(max +" "+integers.indexOf(z));
}
}
