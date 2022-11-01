package Liyambda2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SummaChisel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i=0; i<z; i++) {
                integers.add(in.nextInt());
    }
int sum = IntStream
        .range(integers.indexOf(0)+1,integers.lastIndexOf(0))
        .map(n->integers.get(n))
        .reduce(0,(a,b)->a+b);
        System.out.println(sum);
}
}
