package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class task14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            integers.add(in.nextInt());
        }
        long sum = integers.stream()
                .reduce(0,(a,b)->a+b);
        long nums = integers.stream()
                .count();
        long ggg=sum/nums;
        integers.stream()
                .filter(n->n>ggg)
                .forEach(n->System.out.print(n+" "));

    }
}