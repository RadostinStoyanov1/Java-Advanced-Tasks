package vendingSystem;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Drink {
    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("0.########");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Price: $", this.name));
        sb.append(dc.format(this.price));
        sb.append(String.format(", Volume: %d ml", this.volume));
        return sb.toString();
        //return String.format("Name: %s, Price: $%.1f, Volume: %d ml", this.name, this.price, this.volume);
    }
}
