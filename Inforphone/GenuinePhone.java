package Inforphone;

public class GenuinePhone extends Phone {
    private  String warrantyTime;
    private String warrantyScope;

    public GenuinePhone(String warrantyTime, String warrantyScope) {
        this.warrantyTime = warrantyTime;
        this.warrantyScope = warrantyScope;

    }
    public GenuinePhone(int id, String name, double price, int quantity, String producer, String warrantyTime, String warrantyScope) {
        super(id, name, price, quantity, producer);
        this.warrantyTime = warrantyTime;
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return  super.toString() + "," + warrantyTime+ "," + warrantyScope;
    }
}
