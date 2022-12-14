package kz.bitlab.servlets.SessionTaskTwo;

public class Tovars {
    private int id;
    private String brand;
    private String price;


    public Tovars(){}

    public Tovars(int id, String brand, String price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
