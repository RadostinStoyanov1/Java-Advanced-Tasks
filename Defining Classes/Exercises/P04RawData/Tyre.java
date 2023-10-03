package P14DefiningClasses_Exercise.P04RawData;

public class Tyre {
    private double tyrePressure;
    private int tyreAge;

    public Tyre(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }
}
