package P18Generics_Exercise.P06GenericCountMethodDouble;

public class Box <T extends Comparable<T>> implements Comparable<Box<T>> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }
}
