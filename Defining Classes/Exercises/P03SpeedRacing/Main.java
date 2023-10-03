package P14DefiningClasses_Exercise.P03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFot1Km = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCostFot1Km);
            carsMap.putIfAbsent(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            int kilometers = Integer.parseInt(tokens[2]);

            if (carsMap.get(model).getFuelAmount() >= kilometers * carsMap.get(model).getFuelCostPerKm()) {
                Car newCar = new Car(model,
                        carsMap.get(model).getFuelAmount() - kilometers * carsMap.get(model).getFuelCostPerKm(),
                        carsMap.get(model).getFuelCostPerKm());
                newCar.setTraveledDistance(carsMap.get(model).getTraveledDistance() + kilometers);
                carsMap.put(model, newCar);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            Car car = carList.stream().filter(e -> e.getModel().equals(model)).findFirst().orElse(null);
            command = scanner.nextLine();
        }

        carsMap.values().stream().forEach(System.out::print);


    }
}
