package P04StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> robotsMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\;");
        for (String s : input) {
            String name = s.split("\\-")[0];
            int time = Integer.parseInt(s.split("\\-")[1]);
            robotsMap.put(name, time);
        }

        String[] inputTime = scanner.nextLine().split("\\:");
        int currentTime = Integer.parseInt(inputTime[2]);
        currentTime += (Integer.parseInt(inputTime[1])) * 60;
        currentTime += (Integer.parseInt(inputTime[0])) * 3600;

        Map<String, Integer> robotsEndJobTime = new LinkedHashMap<>();
        for (String s : robotsMap.keySet()) {
            robotsEndJobTime.put(s, currentTime);
        }

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();
        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }

        while (!productsQueue.isEmpty()) {
            currentTime++;
            String currentProductName = productsQueue.poll();
            boolean isCurrentProductProcessed = false;
            int processingTime = 0;
            String robotName = "";

            for (Map.Entry<String, Integer> entry : robotsEndJobTime.entrySet()) { //Check if currentTime is less than the end time in the Map robotsEndJobTime
                if (currentTime >= entry.getValue()) {
                    isCurrentProductProcessed = true;
                    robotName = entry.getKey();
                    processingTime = robotsMap.get(robotName);
                    break;
                }
            }

            if (!isCurrentProductProcessed) {
                productsQueue.offer(currentProductName);
                continue;
            }

            robotsEndJobTime.put(robotName, currentTime + processingTime);

            String currentTimeFormatted = convertTime(currentTime);
            System.out.printf("%s - %s %s%n", robotName, currentProductName, currentTimeFormatted);
        }

    }

    public static String convertTime(int currentTime) {
        int hours = (currentTime / 3600) % 24;
        int leftSeconds = currentTime % 3600;
        int minutes = leftSeconds / 60;
        int seconds = leftSeconds % 60;
        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }

}
