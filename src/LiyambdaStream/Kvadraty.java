package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;

public class Kvadraty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a; i++)
            integers.add(in.nextInt());

        integers.stream()
                .forEach(n -> System.out.print(n * n + " "));

    }
}
