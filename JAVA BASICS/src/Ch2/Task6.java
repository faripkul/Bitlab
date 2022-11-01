package Ch2;

public class Task6 {

    public static void main(String[] args) {
        Player [] X = new Player[5];
        X[0] = new Player(1, "kcfjh", "dkjfn", "dlkfhj");
        X[1] = new Player(2, "kcfjh", "dkjfn", "dlkfhj");
        X[2] = new Player(3, "kcfjh", "dkjfn", "dlkfhj");
        X[3] = new Player(4, "kcfjh", "dkjfn", "dlkfhj");
        X[4] = new Player(5, "kcfjh", "dkjfn", "dlkfhj");
        Player [] Y = new Player[5];
        Y[0] = new Player(1, "kcfjh", "dkjfn", "dlkfhj");
        Y[1] = new Player(2, "kcfjh", "dkjfn", "dlkfhj");
        Y[2] = new Player(3, "kcfjh", "dkjfn", "dlkfhj");
        Y[3] = new Player(4, "kcfjh", "dkjfn", "dlkfhj");
        Y[4] = new Player(5, "kcfjh", "dkjfn", "dlkfhj");
        Club Kairat = new Club ("Kairat", "Almaty", 7, X);
        Club Ordabasy = new Club ("Ordabasy", "Shymkent", 6, Y);
        Club [] z = {Kairat, Ordabasy};
        for (int i=0; i<z.length; i++) {
            z[i].printClubData();
        }
    }
}


class Club {
    String name;
    String country;
    int ratingPoints;
    Player[] players;

    public Club() {
        this.name = "No Name";
        this.country = "No Country";
        this.ratingPoints = 0;
        this.players = null;
    }

    public Club(String name, String country, int ratingPoints, Player[] players) {
        this.name = name;
        this.country = country;
        this.ratingPoints = ratingPoints;
        this.players = players;
    }

    public void printClubData() {
        System.out.println(name + " " + country + " " + ratingPoints);

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
        }
    }
}



class Player {
    int number;
    String name;
    String surname;
    String position;

    public Player() {
        this.number = 0;
        this.name = "No Name";
        this.surname = "No Surame";
        this.position = "No Position";
    }
    public Player (int number, String name, String surname, String position) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
    public String toString() {
        return number+" "+name+" "+surname+" "+position;
    }
}
