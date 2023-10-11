package P17Generics.P01JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;
    //мястото, в което съхраняваме данните. В момента е null


    public Jar() {
        //Създаваме празен стек, в който да се добавят елементи. В null не може да добавяме елементи
        this.stack = new ArrayDeque<T>();
    }
    //Метод за добавяне на елемент
    public void add(T element) {
        this.stack.push(element);
    }

    //Метод за премахване на елемент
    public T remove() {
        return this.stack.pop();
    }
}
