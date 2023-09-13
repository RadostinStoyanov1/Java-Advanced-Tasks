package P07SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        nums = nums.stream().sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        int counter = 1;
        for (Integer num : nums) {
            if (counter > 3) {
                break;
            }
            System.out.print(num + " ");
            counter++;
        }
        System.out.println();
    }
}
