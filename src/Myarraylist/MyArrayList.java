package Myarraylist;

import java.util.Arrays;

public class MyArrayList< E > {
    private int size = 0;
    private Object mas [] = new Object[10];

    public void add(E values) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                mas[i] = values;
                size++;
                return;
            }
        }

        Object[] newMas = new Object[mas.length + mas.length / 2];
        System.arraycopy(mas, 0, newMas, 0, mas.length);
        mas = newMas;

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                mas[i] = values;
                size++;
                break;
            }
        }
    }
public void remove(int index){
        mas[index] = null;
        size = size - 1;
     for (int i = index; i < size - 1; i++){
         mas[i] = mas[i + 1];
     }
}
public void clear(){
    Object mas3 [] = new Object[10];
    mas =mas3;
    size = 0;
}
public int size(){
    return size;
}
   public E get(int index){
       return (E) mas[index];
   }
    @Override
    public String toString() {
        return "MyArrayList{" +
                "mas=" + Arrays.toString(mas) +
                '}';
    }
}

