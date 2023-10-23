package ExamPreparationTasks;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicsQueue::offer);

        Map<String, Integer> presentsMap = new TreeMap<>();
        presentsMap.put("Doll", 0);
        presentsMap.put("Wooden train", 0);
        presentsMap.put("Teddy bear", 0);
        presentsMap.put("Bicycle", 0);

        while (!materialsStack.isEmpty() && !magicsQueue.isEmpty()) {
            int material = materialsStack.peek();
            int magic = magicsQueue.peek();
            int totalMagic = magic * material;

            if (totalMagic == 150) {
                materialsStack.pop();
                magicsQueue.poll();
                presentsMap.put("Doll", presentsMap.get("Doll") + 1);
            } else if (totalMagic == 250) {
                materialsStack.pop();
                magicsQueue.poll();
                presentsMap.put("Wooden train", presentsMap.get("Wooden train") + 1);
            } else if (totalMagic == 300) {
                materialsStack.pop();
                magicsQueue.poll();
                presentsMap.put("Teddy bear", presentsMap.get("Teddy bear") + 1);
            } else if (totalMagic == 400) {
                materialsStack.pop();
                magicsQueue.poll();
                presentsMap.put("Bicycle", presentsMap.get("Bicycle") + 1);
            } else if (totalMagic < 0) {
                int sum = material + magic;
                materialsStack.pop();
                magicsQueue.poll();
                materialsStack.push(sum);
            } else if (totalMagic > 0) {
                magicsQueue.poll();
                materialsStack.push(materialsStack.pop() + 15);
            } else {
                if (material == 0) {
                    materialsStack.pop();
                }
                if (magic == 0) {
                    magicsQueue.poll();
                }
            }
        }
        boolean isDollAndTrain = presentsMap.get("Doll") > 0 && presentsMap.get("Wooden train") > 0;
        boolean isBearAndBicycle = presentsMap.get("Teddy bear") > 0 && presentsMap.get("Bicycle") > 0;
        if (isDollAndTrain || isBearAndBicycle) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!magicsQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        for (Map.Entry<String, Integer> entry : presentsMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
