package Ex1TryCatch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[5];
        for (int i = 0; i < users.length; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Insert name: ");
            String name = in.next();
            System.out.println("Insert surname: ");
            String surname = in.next();
            System.out.println("Insert age: ");
            int age;
            try {
                age = Integer.parseInt(in.next());
            } catch (Exception e) {
                age = 0;
                e.printStackTrace();
            }

            users[i] = new User(name, surname, age);
        }

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getUser());
        }

        int sum = 0;
        for (int i = 0; i < users.length; i++) {
            sum = sum + users[i].age;
        }
            System.out.println(sum / 5);
        }
    }

