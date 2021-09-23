package com.tms.lesson10.prog01UserStringCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. Заполнить коллекцию 5 строками введенными с консоли.
 * В каждой строке заменить "+" на "+++".
 * Вывести коллекцию-результат на экран.
 */
public class UserStringCollection {

    public static void main(String[] args) {
        ArrayList<String> userStringArray = new ArrayList<>(5);

        try (Scanner sc = new Scanner(System.in)) {

            for (int step = 0; step < 5; step++) {
                System.out.print("Введите строку для заполнения коллекции из 5 строк: ");
                String str = sc.nextLine();
                str = str.replace("+", "+++"); // Заменяем все "+" в строке на "+++". Строки неизменны, поэтому повторно назначаем возвращаемое значение той же переменной String
                userStringArray.add(str); // Добавляем строку в коллекцию
            }

            System.out.println(userStringArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
