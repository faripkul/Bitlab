package Interface2;

public class HRManagers implements Workers {
    int id;
    String fullName;
    int salary;

    public HRManagers() { // need delete this method
        this.id = 0;
        this.fullName = "No Fullname";
        this.salary = 0;
    }

    public HRManagers(int id, String fullName, int salary) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
    }

    @Override
    public String getWorkerData() {
        return "id:" + id + " ,fullname:" + fullName + " ,salary:" + salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
