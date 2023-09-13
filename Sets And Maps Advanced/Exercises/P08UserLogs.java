package P08SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> ipMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputParts = input.split("\\s+");
            String ip = inputParts[0].substring(3);
            String user = inputParts[2].substring(5);

            if (!ipMap.containsKey(user)) {
                ipMap.put(user, new LinkedHashMap<>());
            }
            if (!ipMap.get(user).containsKey(ip)) {
                ipMap.get(user).put(ip, 0);
            }
            ipMap.get(user).put(ip, ipMap.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        ipMap.forEach((key, value) -> {
            System.out.printf("%s: \n", key);
            int counter = 0;
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                System.out.printf("%s => %d", entry.getKey(), entry.getValue());
                if (counter != value.size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
                counter++;
            }
        });

    }
}
