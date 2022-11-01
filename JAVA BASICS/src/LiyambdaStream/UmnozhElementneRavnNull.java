package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;

public class UmnozhElementneRavnNull {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int z = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            integers.add(in.nextInt());
        }
        long sum = integers.stream()
                .filter(n->n!=0)
                .reduce(1,(a,b)->a*b);
        System.out.print(sum);

    }
}

