package P04StacksAndQueues_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plantsList = new ArrayList<>(n);
        plantsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int previousDaySize = 0;
        int currentDaySize = plantsList.size();
        int daysCounter = 0;

        while (currentDaySize != previousDaySize) {
            ArrayDeque<Integer> newPlantsQueue = new ArrayDeque<>();
            for (int i = 0; i < plantsList.size(); i++) {
                if (i == 0) {
                    newPlantsQueue.offer(plantsList.get(0));
                    continue;
                }
                if (plantsList.get(i) <= plantsList.get(i - 1)) {
                    newPlantsQueue.offer(plantsList.get(i));
                }
            }
            plantsList.clear();
            while (!newPlantsQueue.isEmpty()) {
                plantsList.add(newPlantsQueue.poll());
            }
            previousDaySize = currentDaySize;
            currentDaySize = plantsList.size();
            daysCounter++;
        }
        System.out.println(daysCounter - 1);
    }
}
