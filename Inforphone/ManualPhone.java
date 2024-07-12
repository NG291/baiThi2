package Inforphone;

public class ManualPhone extends Phone {
    private String country;
    private String status;

    public ManualPhone(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public ManualPhone(int id, String name, double price, int quantity, String producer, String country, String status) {
        super(id, name, price, quantity, producer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return toString()+ ","+ country +","+status;
    }

    @Override
    public String toString() {
        return super.toString() + ","+ country +","+status;
    }
}
