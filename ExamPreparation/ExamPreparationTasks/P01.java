package ExamPreparationTasks;

import java.util.*;
import java.util.stream.Collectors;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuelQuantityStack = new ArrayDeque<>();
        ArrayDeque<Integer> additionalFuelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> neededFuelQueue = new ArrayDeque<>();
        List<String> reachedAltitudes = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(fuelQuantityStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(additionalFuelQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(neededFuelQueue::offer);


        while (!neededFuelQueue.isEmpty()) {
            int initialFuel = fuelQuantityStack.pop();
            int removeFuel = additionalFuelQueue.poll();
            int neededFuel = neededFuelQueue.poll();

            if ((initialFuel - removeFuel) >= neededFuel) {
                int altitudeToAdd = reachedAltitudes.size() + 1;
                reachedAltitudes.add(String.format("Altitude %d", altitudeToAdd));
                System.out.printf("John has reached: Altitude %d%n", reachedAltitudes.size());
                continue;
            } else {
                System.out.printf("John did not reach: Altitude %d%n", reachedAltitudes.size() + 1);
                break;
            }
        }

        if (neededFuelQueue.isEmpty() && reachedAltitudes.size() == 4) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");
            if (reachedAltitudes.size() == 0) {
                System.out.println("John didn't reach any altitude.");
            } else if (reachedAltitudes.size() > 0) {
                String altitudes = reachedAltitudes.stream().map(String::valueOf).collect(Collectors.joining(", "));
                System.out.println("Reached altitudes: " + altitudes);
            }
        }
    }
}
