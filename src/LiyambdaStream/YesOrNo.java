//package LiyambdaStream;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class YesOrNo {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int z = in.nextInt();
//        ArrayList<Integer> integers = new ArrayList<>();
//        for (int i = 0; i < z; i++) {
//            integers.add(in.nextInt());
//        }
//        int y = in.nextInt();
//        long count = integers.stream()
//                .filter(n->n==y).count();
//                if (count==0)
//        System.out.print("NO");
//        else System.out.println("YES "+integers.indexOf(y));
//
//    }
//}
//
