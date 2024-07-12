package Inforphone;

public class GenuinePhone extends Phone {
    private  String WarrantyTime;
    private String WarrantyScope;

    public GenuinePhone(String warrantyTime, String warrantyScope) {
        WarrantyTime = warrantyTime;
        WarrantyScope = warrantyScope;
    }

    public GenuinePhone(int id, String name, double price, int quantity, String producer, String warrantyTime, String warrantyScope) {
        super(id, name, price, quantity, producer);
        WarrantyTime = warrantyTime;
        WarrantyScope = warrantyScope;
    }

    @Override
    public String toString() {
        return "GenuinePhone{" +
                "WarrantyTime='" + WarrantyTime + '\'' +
                ", WarrantyScope='" + WarrantyScope + '\'' +
                '}';
    }
}
