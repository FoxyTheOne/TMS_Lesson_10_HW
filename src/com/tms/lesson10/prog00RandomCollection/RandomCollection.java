package com.tms.lesson10.prog00RandomCollection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 0. Заполнить коллекцию 10 рандомными целыми числами в промежутке от 2 до 98.
 * Найти два максимальных элемента и вывести их на экран.
 */
public class RandomCollection {

    public static void main(String[] args) {
        ArrayList<Integer> randomArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            randomArray.add((int) (Math.random() * (99 - 2)) + 2); // Диапазон целых чисел [2; 99)(99 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)
        }
        System.out.println(randomArray);

        Collections.sort(randomArray); // Отсортировали коллекцию
        int lastIndex = randomArray.size() - 1; // Индекс последнего элемента (максимальное значение)
        System.out.println("Два максимальных значения в массиве - " + randomArray.get(lastIndex) + " и " + randomArray.get(lastIndex - 1));
    }

}
