package P08SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, int[]>> dragonsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armour = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if (!dragonsMap.containsKey(type)) {
                dragonsMap.put(type, new TreeMap<>());
            }
            if (!dragonsMap.get(type).containsKey(name)) {
                dragonsMap.get(type).put(name, new int[3]);
            }
            dragonsMap.get(type).get(name)[0] = damage;
            dragonsMap.get(type).get(name)[1] = health;
            dragonsMap.get(type).get(name)[2] = armour;
        }

        dragonsMap.forEach((key, value) -> {
            double[] avgValues = calculateAvg(value);
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key, avgValues[0], avgValues[1], avgValues[2]);
            value.forEach((k, v) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", k, v[0], v[1], v[2]);
            });
        });
    }

    private static double[] calculateAvg(TreeMap<String, int[]> dragons) {
        double dragonsAmount = dragons.size();
        int sumDamage = 0;
        int sumHealth = 0;
        int sumArmour = 0;
        for (Map.Entry<String, int[]> entry : dragons.entrySet()) {
            sumDamage += entry.getValue()[0];
            sumHealth += entry.getValue()[1];
            sumArmour += entry.getValue()[2];
        }
        return new double[] {sumDamage / dragonsAmount,
                            sumHealth / dragonsAmount,
                            sumArmour / dragonsAmount
        };
    }
}
