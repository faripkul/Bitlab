package Interface2;

public class Programmers implements Workers {
    int id;
    String nickname;
    int salary;
    int bonusSalary;
    double KPIValue;

    public Programmers() { // need delete this method
        this.id = 0;
        this.nickname = "No Nickname";
        this.salary = 0;
        this.bonusSalary = 0;
        this.KPIValue = 0;
    }

    public Programmers(int id, String nickname, int salary, int bonusSalary, double KPIValue) {
        this.id = id;
        this.nickname = nickname;
        this.salary = salary;
        this.bonusSalary = bonusSalary;
        this.KPIValue = KPIValue;
    }

    @Override
    public String getWorkerData() {
        return "id:" + id + " ,nickname:" + nickname
                + " ,salary:" + salary + " ,bonusSalary:" + bonusSalary + " ,KPIValue:" + KPIValue;
    }

    @Override
    public double getSalary() {
        return salary + KPIValue * bonusSalary;
    }
}

