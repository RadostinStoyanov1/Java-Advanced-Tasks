package P18Generics_Exercise.P08CustomListSorter;

public class Sorter {

    private Sorter() {
    }

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            T currentElement = list.getElement(i);
            for (int j = i + 1; j < list.getSize(); j++) {
                if (currentElement.compareTo(list.getElement(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }

    }
}
