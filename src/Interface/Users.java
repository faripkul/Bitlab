package Interface;

public class Users {
    String name;
    String surname;

    public Users(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void getAllUsers() {
        System.out.println("name: " + name + ", "+ "surname: " + surname);
    }
    public void getUsersByName() {
        if (name.equalsIgnoreCase("John")) {
            System.out.println("name: " + name + ", " + "surname: " + surname);
        }
    }
        public void getUsersBySurname() {
            if (surname.equalsIgnoreCase("Smith")) {
                System.out.println("name: " + name + ", " + "surname: " + surname);
            }
        }
    }




