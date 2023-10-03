package P13DefiningClasses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());

        for (int count = 0; count < countCars; count++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car;

            if (data.length == 3) {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            } else {
                car = new Car(data[0]);
            }
            System.out.println(car.toString());
        }

    }
}
