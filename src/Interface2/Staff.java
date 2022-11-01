package Interface2;

public class Staff implements Workers {
    int id;
    String name;
    String surname;
    int salary;

    public Staff() { // need delete this method
        this.id = 0;
        this.name = "No Name";
        this.surname = "No Surname";
        this.salary = 0;
    }

    public Staff(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String getWorkerData() {
        return "id:" + id + " ,name:" + name + " ,surname:" + surname + " ,salary:" + salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

}
