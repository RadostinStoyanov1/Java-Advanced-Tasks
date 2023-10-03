package P14DefiningClasses_Exercise.P04RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tyre1Pressure = Double.parseDouble(input[5]);
            int tyre1Age = Integer.parseInt(input[6]);
            double tyre2Pressure = Double.parseDouble(input[7]);
            int tyre2Age = Integer.parseInt(input[8]);
            double tyre3Pressure = Double.parseDouble(input[9]);
            int tyre3Age = Integer.parseInt(input[10]);
            double tyre4Pressure = Double.parseDouble(input[11]);
            int tyre4Age = Integer.parseInt(input[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tyre1Pressure, tyre1Age,
                    tyre2Pressure, tyre2Age, tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);

            carsList.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : carsList) {
                if (car.getCargoType().equals("fragile") && car.isTyreUnder1Pressure()) {
                    System.out.println(car.getModel());
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : carsList) {
                if (car.getCargoType().equals("flamable") && car.isEnginePowerEnough()) {
                    System.out.println(car.getModel());
                }
            }
        }


    }
}
