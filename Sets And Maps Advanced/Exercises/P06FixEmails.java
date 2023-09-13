package P08SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> namesMap = new LinkedHashMap<>();

        String inputName = scanner.nextLine();

        while (!inputName.equals("stop")) {
            String inputEmail = scanner.nextLine();
            if (!inputEmail.endsWith("uk") && !inputEmail.endsWith("us") && !inputEmail.endsWith("com")) {
                namesMap.put(inputName, inputEmail);
            }

            inputName = scanner.nextLine();
        }

        namesMap.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));

    }
}
