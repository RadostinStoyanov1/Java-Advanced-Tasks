package P13DefiningClasses;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car () {

    }

    public Car (String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public Car (String brand) {
        this.setBrand(brand);
        this.setModel("unknown");
        this.setHorsePower(-1);
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), getHorsePower());
    }

    public static void sayBeep() {
        System.out.println("Beep");
    }
}
