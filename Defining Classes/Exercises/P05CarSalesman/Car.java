package P14DefiningClasses_Exercise.P05CarSalesman;

public class Car {
    private String carModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String carModel, Engine engine, int weight) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String carModel, Engine engine, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = 0;
        this.color = color;
    }

    public Car(String carModel, Engine engine, int weight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.carModel).append(":").append(System.lineSeparator());
        sb.append(engine.getEngineModel()).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(engine.getEnginePower()).append(System.lineSeparator());
        if (engine.getDisplacement() == 0) {
            sb.append("Displacement: n/a").append(System.lineSeparator());
        } else {
            sb.append("Displacement: ").append(engine.getDisplacement()).append(System.lineSeparator());
        }
        sb.append("Efficiency: ").append(engine.getEfficiency()).append(System.lineSeparator());
        if (this.weight == 0) {
            sb.append("Weight: ").append("n/a").append(System.lineSeparator());
        } else {
            sb.append("Weight: ").append(this.weight).append(System.lineSeparator());
        }
        sb.append("Color: ").append(this.color).append(System.lineSeparator());

        return sb.toString();
    }
}
