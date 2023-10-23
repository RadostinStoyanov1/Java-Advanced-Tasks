package magazine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        Cloth cloth = data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst().orElse(null);
        if (cloth != null) {
            return this.data.remove(cloth);
        } else {
            return false;
        }
    }

    public Cloth getSmallestCloth() {
        return this.data.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getSize(), c2.getSize()))
                .collect(Collectors.toList())
                .get(0);
    }

    public Cloth getCloth(String color) {
        return this.data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s magazine contains:", type));
        this.data.forEach(cloth -> {
            sb.append(System.lineSeparator());
            sb.append(cloth.toString());
        });
        return sb.toString();
    }
}
