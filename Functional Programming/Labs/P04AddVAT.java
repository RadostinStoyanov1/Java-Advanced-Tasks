package P11FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Function<Double, Double> addVAT = num -> num * 1.2;
        //Consumer<Double> printFormattedPrice = price -> System.out.printf("%.2f%n", price); //with Consumer

        System.out.println("Prices with VAT:");
        prices.forEach(price -> {
            double priceWithVAT = addVAT.apply(price);
            System.out.printf("%.2f%n", priceWithVAT);
            //printFormattedPrice.accept(priceWithVAT); //Printing using Consumer
        });
    }
}
