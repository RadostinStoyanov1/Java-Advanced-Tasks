package ExamPreparationTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> drinksQueue = new ArrayDeque<>();
        int consumedCaffeine = 0;

        Arrays.stream(scanner.nextLine().trim().split(", ")).forEach(e -> caffeineStack.push(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().trim().split(", ")).forEach(e -> drinksQueue.offer(Integer.parseInt(e)));

        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()) {
            int currentCaffeine = caffeineStack.pop();
            int currentDrink = drinksQueue.poll();
            int caffeineToDrink = currentCaffeine * currentDrink;
            if ((caffeineToDrink + consumedCaffeine) <= 300) {
                consumedCaffeine += caffeineToDrink;
            } else {
                drinksQueue.offer(currentDrink);
                if (consumedCaffeine < 30) {
                    consumedCaffeine = 0;
                } else {
                    consumedCaffeine -= 30;
                }
            }
        }
        if (drinksQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            String leftDrinks = drinksQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            //String leftDrinks = drinksQueue.toString().replaceAll("\\[", "").replaceAll("]", "");
            /*String leftDrinks = String.join(", ", drinksQueue.toString());
            leftDrinks = leftDrinks.replace("[", "").replace("]", "");*/
            System.out.printf("Drinks left: " + leftDrinks + System.lineSeparator());
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", consumedCaffeine);
    }
}
