package Interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Users u1 = new Users("John", "Smith");
        Users u2 = new Users("ghfgh", "xfgfhg");
        Users u3 = new Users("John", "fghfff");
        Users u4 = new Users("xfgfd", "aedas");
        Users u5 = new Users("gfdh", "zdfs");
        Users u6 = new Users("John", "weg");
        Users u7 = new Users("John", "Smith");
        Users u8 = new Users("shre", "Smith");
        Users u9 = new Users("John", "Smith");
        Users u10 = new Users("op", "Smith");
        Users []users = {u1, u2,u3,u4,u5,u6,u7,u8,u9,u10};
        for (int i=0; i<users.length;i++) {
            users[i].getUsersBySurname();
            users[i].getUsersByName();
            users[i].getAllUsers();
         }

    }
}


