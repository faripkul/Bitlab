package CollectionArray.ex2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankApplication b1 = new BankApplication("Forte");
        BankApplication b2 = new BankApplication("Kaspi");
        BankApplication b3 = new BankApplication("Jusan");
        b1.addAccount(new Account(516, "fkv","okjf;g", 500000));
        b1.addAccount(new Account(516, "fkv","okjf;g", 900000));
        b1.addAccount(new Account(516, "fkv","okjf;g", 400000));
        b1.addAccount(new Account(516, "fkv","okjf;g", 800000));
        b1.addAccount(new Account(516, "fkv","okjf;g", 40000));
        b2.addAccount(new Account(516, "fkv","okjf;g", 165498));
        b2.addAccount(new Account(516, "fkv","okjf;g", 2654));
        b2.addAccount(new Account(516, "fkv","okjf;g", 9532));
        b2.addAccount(new Account(516, "fkv","okjf;g", 58133));
        b2.addAccount(new Account(516, "fkv","okjf;g", 485162));
        b3.addAccount(new Account(516, "fkv","okjf;g", 165498));
        b3.addAccount(new Account(516, "fkv","okjf;g", 2654));
        b3.addAccount(new Account(516, "fkv","okjf;g", 9532));
        b3.addAccount(new Account(516, "fkv","okjf;g", 58133));
        b3.addAccount(new Account(516, "fkv","okjf;g", 485162));

        ArrayList<BankApplication> bankList= new ArrayList<>();
        BankApplication max;
        bankList.add(b1);
        bankList.add(b2);
        bankList.add(b3);

            for (int i = 0; i < bankList.size(); i++) {
                for (int j = 0; j < bankList.size(); j++) {
                    if (bankList.get(i). getAverageBalance() < bankList.get(j). getAverageBalance()) {
                        max = bankList.get(i);
                        bankList.set(i, bankList.get(j));
                        bankList.set(j,max);
                    }
                }
            }
           for (int i=0; i<bankList.size(); i++)
               System.out.println(bankList.get(i).getBankData());
        }
    }