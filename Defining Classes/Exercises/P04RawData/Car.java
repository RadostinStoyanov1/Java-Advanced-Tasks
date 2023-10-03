package P14DefiningClasses_Exercise.P04RawData;

public class Car {
    private String model;

    private Engine engine;
    private Cargo cargo;
    private Tyre tyre1;
    private Tyre tyre2;
    private Tyre tyre3;
    private Tyre tyre4;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               double tyre1Pressure, int tyre1Age,
               double tyre2Pressure, int tyre2Age,
               double tyre3Pressure, int tyre3Age,
               double tyre4Pressure, int tyre4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tyre1 = new Tyre(tyre1Pressure, tyre1Age);
        this.tyre2 = new Tyre(tyre2Pressure, tyre2Age);
        this.tyre3 = new Tyre(tyre3Pressure, tyre3Age);
        this.tyre4 = new Tyre(tyre4Pressure, tyre4Age);
    }

    public String getModel() {
        return model;
    }

    public String getCargoType() {
        return cargo.getCargoType();
    }

    public boolean isTyreUnder1Pressure() {
        return this.tyre1.getTyrePressure() < 1 || this.tyre2.getTyrePressure() < 1 ||
                this.tyre3.getTyrePressure() < 1 || this.tyre4.getTyrePressure() < 1;
    }

    public boolean isEnginePowerEnough() {
        return this.engine.getEnginePower() > 250;
    }
}
