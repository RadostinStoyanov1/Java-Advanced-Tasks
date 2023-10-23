package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        Child child = registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
        if (child != null) {
            return this.registry.remove(child);
        } else {
            return false;
        }
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        registry.stream().sorted((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()));
        List<Child> sortedListOFChildren = this.registry.stream().sorted(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:\n", this.name));
        for (Child child : sortedListOFChildren) {
            sb.append("--");
            sb.append(System.lineSeparator());
            sb.append(child);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


}
