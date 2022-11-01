package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(in.nextInt());
    }
        long sum = integers.stream()
                .reduce(0,(a,b)->a+b);
                System.out.print(sum);
    }
}