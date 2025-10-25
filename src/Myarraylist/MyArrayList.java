package Myarraylist;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private Object mas[] = new Object[10];

    public void add(E values) {
        if (size == mas.length) {
            Object[] newMas = new Object[mas.length + mas.length / 2];
            System.arraycopy(mas, 0, newMas, 0, mas.length);
            mas = newMas;
        }

        mas[size] = values;
        size++;
    }

    public void remove(int index) {
        mas[index] = null;
        for (int i = index; i < size - 1; i++) {
            mas[i] = mas[i + 1];
        }
        mas[size - 1] = null;
        size--;
    }

    public void clear() {
        Object mas3[] = new Object[10];
        mas = mas3;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return (E) mas[index];
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "mas=" + Arrays.toString(mas) +
                '}';
    }
}

