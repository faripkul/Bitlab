package LiyambdaStream;

import java.util.ArrayList;
import java.util.Scanner;

public class delenieNaKBezOstatka {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    ArrayList<Integer> integers = new ArrayList<>();
        int k = in.nextInt();
        for (int i = 0; i < a; i++)
            integers.add(in.nextInt());

        integers.stream()
                .filter(n -> n%k==0 && n!=0)
            .forEach(n -> System.out.print(n+" "));
}
}


