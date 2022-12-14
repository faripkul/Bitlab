package kz.bitlab.servlets.task1;

public class Items {
    private Long id;
    private String name;
    private String country;
    private double price;
    private int amount;

    public Items(){}


    public Items(Long id, String name, String country, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
