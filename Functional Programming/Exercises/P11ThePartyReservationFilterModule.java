package P12FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Print")) {
            String[] tokens = line.split(";");
            String name = tokens[1] + tokens[2];

            if (line.contains("Add")) {
                Predicate<String> predicate;
                switch (tokens[1]) {
                    case "Starts with":
                        predicate = s -> s.startsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends with":
                        predicate = s -> s.endsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }
            } else {
                predicates.remove(name);
            }

            line = scanner.nextLine();
        }

        for (String name : names) {
            boolean isGoing = true;
            for (String key : predicates.keySet()) {
                if (predicates.get(key).test(name)) {
                    isGoing = false;
                    break;
                }
            }
            if (isGoing) {
                System.out.print(name + " ");
            }
        }

    }
}
