package P17Generics.P03GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(9, 5);

        System.out.println(scale.getHeavier());
    }
}
