package LiyambdaStream;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.net.ProxySelector;

public class findpositiveInt {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a; i++)
            integers.add(in.nextInt());

        integers.stream()
                .filter(n -> n > 0)
                .forEach(n -> System.out.print(n+" "));
    }
}




