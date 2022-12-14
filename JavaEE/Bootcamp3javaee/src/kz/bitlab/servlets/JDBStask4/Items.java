package kz.bitlab.servlets.JDBStask4;

public class Items {
  private Long id;
  private String name;
  private String description;
  private double price;
  private Brands brand;

  public Items(){}

    public Items(Long id, String name, String description, double price, Brands brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
//        this.brand = brand;
    }
}
