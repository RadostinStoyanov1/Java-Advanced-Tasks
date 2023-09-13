package P08SetsAndMapsAdvanced_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebookMap = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNum = tokens[1];

            phonebookMap.put(name, phoneNum);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (phonebookMap.containsKey(input)) {
                String phoneNumber = phonebookMap.get(input);
                System.out.printf("%s -> %s\n", input, phoneNumber);
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
            input = scanner.nextLine();
        }

    }
}
