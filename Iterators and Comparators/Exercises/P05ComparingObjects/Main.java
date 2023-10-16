package P20IteratorsAndComparators_Exercise.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Person> personsList = new ArrayList<>();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            personsList.add(person);

            line = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person currentPerson = personsList.get(n - 1);

        int equals = 0;
        int diff = 0;

        for (Person person : personsList) {
            int result = currentPerson.compareTo(person);
            if (result == 0) {
                equals++;
            } else {
                diff++;
            }
        }

        if (equals <= 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d\n", equals, diff, personsList.size());
        }

    }
}
