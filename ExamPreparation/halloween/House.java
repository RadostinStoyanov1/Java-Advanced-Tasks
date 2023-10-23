package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        for (Kid kid : data) {
            if (kid.getName().equals(name)) {
                this.data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public Kid getKid(String street) {
        return this.data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:");
        for (Kid kid : data) {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s from %s street", kid.getName(), kid.getStreet()));
        }
        return sb.toString();
    }
}
