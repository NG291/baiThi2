package Inforphone;

public abstract class Phone {
    private  int id;
    private String name;
    private double price;
    private  int   quantity;
    private String producer;

    public Phone(){};

    public Phone(int id, String name, double price, int quantity, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public abstract String getInfo();


    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + quantity + "," + producer;
    }
}
