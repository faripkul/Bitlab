package CollectionArray.ex2;

import java.util.ArrayList;

public class BankApplication {
    protected String name;
    ArrayList<Account> accounts = new ArrayList<>();

    public BankApplication(String name) {
        this.name = name;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    void addAccount(Account a){
      accounts.add(a);
    }
    void removeAccount(int i){
       accounts.remove(i);
    }
    Account getMaxAccount() {
        int maxBalance = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getBalance() > maxBalance)
                maxBalance = (int)accounts.get(i).getBalance();
        }
    return accounts.get(maxBalance);
    }
    double getAverageBalance(){
        int sum = 0;
        for (int i = 0; i < accounts.size(); i++) {
            sum = (int)accounts.get(i).getBalance()+sum;
    }
    return sum/accounts.size();
    }
    double getTotalBalance(){
    int sum = 0;
        for (int i = 0; i < accounts.size(); i++) {
            sum = (int)accounts.get(i).getBalance()+sum;
        }
        return sum;
    }
    int totalAccounts() {
       return accounts.size();
        }
    String getBankData(){
        return "name: " + getName() + ", " + "Accounts: " + totalAccounts() + ", " + "balance: "
                + getTotalBalance() + ", " + "srBalance: " + getAverageBalance();
    }
}