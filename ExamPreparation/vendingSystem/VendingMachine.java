package vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private List<Drink> drinks;
    private int buttonCapacity;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                drinks.remove(drink);
                return true;
            }
        }
        return false;
    }

    public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).get();
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).get();
    }

    public String buyDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                return drink.toString();
            }
        }
        return null;
        //return String.format("%s", this.drinks.stream().filter(e -> e.getName().equals(name)).findFirst());
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:");
        for (Drink drink : drinks) {
            sb.append(System.lineSeparator());
            sb.append(drink.toString());
        }
        return sb.toString();
    }
}
