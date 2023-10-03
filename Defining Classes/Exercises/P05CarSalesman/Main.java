package P14DefiningClasses_Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> enginesMap = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine = createEngine(input);
            enginesMap.put(input[0], engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[1];
            Engine engine = enginesMap.get(engineModel);
            Car car = createCar(input, engine);
            cars.add(car);
        }

        cars.forEach(System.out::print);


    }

    private static Car createCar(String[] input, Engine engine) {
        String carModel = input[0];
        int weight;
        String color;
        if (input.length == 2) {
            weight = 0;
            color = "n/a";
        } else if (input.length == 3) {
            char firstChar = input[2].charAt(0);
            if (Character.isDigit(firstChar)) {
                weight = Integer.parseInt(input[2]);
                color = "n/a";
            } else {
                weight = 0;
                color = input[2];
            }
        } else {
            weight = Integer.parseInt(input[2]);
            color = input[3];
        }
        Car car = new Car(carModel, engine, weight, color);
        return car;
    }

    private static Engine createEngine(String[] input) {
        String engineModel = input[0];
        int enginePower = Integer.parseInt(input[1]);
        int displacement;
        String efficiency;
        if (input.length == 2) {
            displacement = 0;
            efficiency = "n/a";
        } else if (input.length == 3) {
            char firstChar = input[2].charAt(0);
            if (Character.isDigit(firstChar)) {
                displacement = Integer.parseInt(input[2]);
                efficiency = "n/a";
            } else {
                displacement = 0;
                efficiency = input[2];
            }
        } else {
            displacement = Integer.parseInt(input[2]);
            efficiency = input[3];
        }
        Engine engine = new Engine(engineModel, enginePower, displacement, efficiency);
        return engine;
    }
}
