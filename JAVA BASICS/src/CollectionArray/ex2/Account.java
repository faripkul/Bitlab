package CollectionArray.ex2;

public class Account {
        int id;
        String name;
        String surname;
        double balance;

        public Account(int id, String name, String surname,double balance) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.balance = balance;

        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }

    public String getSurame() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {

            this.id = id;
        }

        public double getBalance() {

            return balance;
        }

        public void setBalance(double balance) {

            this.balance = balance;
        }
       public String toString() {
          return "id: " + id + ", " + "name: " + name + ", " + "surname: " + surname + ", " + "balance: " + balance;
    }
    }

