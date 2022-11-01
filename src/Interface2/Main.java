//Создайте интерфейс Workers.java в котором есть абстрактные методы:
//
//
//
//        String getWorkerData();
//
//        int getSalary();
//
//
//
//        Получается, вы создаете несколько классов, которые наследуют от интерфейса Workers.java:
//
//
//
//        Staff.java (Рабочие)
//
//        - int id;
//
//        - String name;
//
//        - String surname;
//
//        - int salary;
//
//
//
//
//
//        HRManagers.java (Отдел кадров)
//
//        - int id;
//
//        - String fullName;
//
//        - int salary;
//
//
//
//        Programmers.java (Программисты)
//
//        - int id;
//
//        - String nickname;
//
//        - int salary;
//
//        - int bonusSalary;
//
//        - double KPIValue;
//
//
//
//        Получается у каждого класса есть свои особенности, но ваша задача реализовать абстрактные методы.
//
//        В принципе при вызове метода getSalary() у всех классов возвращается значение зарплаты, но у программистов подсчет зарплаты идет таким образом: salary + KPIValue*bonusSalary. KPIValue - это коэффициент объема работы, выполненный за определенный период, и его значение от 0 до 1 включительно.
//
//
//
//        В основном классе Main.java создайте по 5 объектов рабочих, отдела кадров и программистов.
//
//
//
//        a. Выведите данные рабочего, у которого самая высокая зарплата.
//
//        b. Отсортируйте рабочих, по зарплате, по убыванию.


package Interface2;

public class Main {
    public static void main(String[] args) {
        Staff s1 = new Staff(26, "isfjvn", "dfjnv", 315);
        Staff s2 = new Staff(26, "isfjvn", "dfjnv", 524);
        Staff s3 = new Staff(26, "isfjvn", "dfjnv", 96);
        Staff s4 = new Staff(26, "isfjvn", "dfjnv", 72);
        Staff s5 = new Staff(26, "isfjvn", "dfjnv", 69);
        HRManagers h1 = new HRManagers(15, "ksdj", 1510);
        HRManagers h2 = new HRManagers(15, "ksdj", 151);
        HRManagers h3 = new HRManagers(15, "ksdj", 151);
        HRManagers h4 = new HRManagers(15, "ksdj", 151);
        HRManagers h5 = new HRManagers(15, "ksdj", 151);
        Programmers p1 = new Programmers(165, "ckng", 151, 651, 0.8);
        Programmers p2 = new Programmers(165, "ckng", 151, 651, 0.8);
        Programmers p3 = new Programmers(165, "ckng", 151, 651, 0.8);
        Programmers p4 = new Programmers(165, "ckng", 151, 651, 0.8);
        Programmers p5 = new Programmers(165, "ckng", 151, 651, 0.8);
        Workers[] workers1 = {s1, s2, s3, s4, s5, h1, h2, h3, h4, h5, p1, p2, p3, p4, p5};
        Workers[] workers = getNov(workers1);
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getSalary() == getHighestSalary(workers)) {
                System.out.println(workers[i].getWorkerData());
            }
        }
        for (int i=0; i<workers.length;i++){
            if (workers[i] instanceof Staff)
                System.out.println(workers[i].getWorkerData());
        }
    }

    public static double getHighestSalary(Workers[] workers) {
        double highestSalary = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getSalary() > highestSalary) {
                highestSalary = workers[i].getSalary();
            }
        }
        return highestSalary;
    }

    public static Workers[] getNov(Workers[] workers) {
        Workers nov = new Staff();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < workers.length; j++) {
                if (workers[i].getSalary() < workers[j].getSalary() && workers[i] instanceof Staff && workers[j] instanceof Staff) {
                    nov = workers[i];
                    workers[i] = workers[j];
                    workers[j] = nov;
                }
            }
        }
        return workers;
    }
}