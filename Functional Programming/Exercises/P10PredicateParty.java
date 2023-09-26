package P12FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String removeOrDouble = tokens[0];
            String lastToken = tokens[2];

            for (int i = 0; i < names.size(); i++) {
                BiPredicate<String, String> tester = createTester(tokens);
                if (removeOrDouble.equals("Remove")) {
                    if (tester.test(names.get(i), lastToken)) {
                        names.remove(i);
                        i--;
                    }
                } else if (removeOrDouble.equals("Double")) {
                    if (tester.test(names.get(i), lastToken)){
                        names.add(i + 1, names.get(i));
                        i++;
                    }
                }
            }

            command = scanner.nextLine();
        }
        if (names.size() > 0) {
            Collections.sort(names);
            System.out.println(String.join(", ", names) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }


    }

    private static BiPredicate<String, String> createTester(String[] tokens) {
        String startsEndsLength = tokens[1];
        BiPredicate<String, String> tester = null;
        switch (startsEndsLength) {
            case "StartsWith":
                tester = (guestName, startsEnds) -> guestName.startsWith(startsEnds); //String::startsWith;
                break;
            case "EndsWith":
                tester = String::endsWith;
                break;
            case "Length":
                tester = (guestName, nameLengthStr) -> {
                    int nameLength = Integer.parseInt(tokens[2]);
                    return guestName.length() == nameLength;
                };
                break;
        }
        return tester;
    }
}
