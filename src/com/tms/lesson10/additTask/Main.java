package com.tms.lesson10.additTask;

import com.tms.lesson10.comparator.StudentAgeComparator;
import com.tms.lesson10.comparator.StudentNameComparator;
import com.tms.lesson10.comparator.StudentSurnameComparator;
import com.tms.lesson10.comparator.StudentYearAverageMarkComparator;

import java.util.*;

/**
 * Создать список (List) учеников. Найти и вывести ученика с самым высоким средним баллом используя итератор.
 * Отсортировать и вывести список учеников по полному имени (имя + фамилия), возрасту и среднему баллу, используя компараторы.
 */
public class Main {
    public static void main(String[] args) {
        // Ученики не должны дублироваться - коллекция Set
        // Если работаем со своими классами, нужно переопределить в них equals() и hashCode()
        // Нужна сортировка => TreeSet

        // Сортируем список учеников по полному имени (имя + фамилия), возрасту и среднему баллу, используя компараторы.
        // Для проверки правильности сортировки добавляю в коллекцию одинаковых студентов, но с разным возрастом либо средним баллом
        Comparator<Student> stComp = new StudentNameComparator()
                .thenComparing(new StudentSurnameComparator())
                .thenComparing(new StudentAgeComparator())
                .thenComparing(new StudentYearAverageMarkComparator());
        TreeSet<Student> studentList = new TreeSet(stComp);

        studentList.add(new Student("Aleksandr", "Ivanov", 21, 7));
        studentList.add(new Student("Eduard", "Piatrou", 25, 9.5));
        studentList.add(new Student("Eduard", "Piatrou", 20, 8.5));
        studentList.add(new Student("Eduard", "Bykov", 25, 7.5));
        studentList.add(new Student("Eduard", "Piatrou", 25, 9));
        studentList.add(new Student("Dmitrij", "Gartel", 22, 8.5));
        studentList.add(new Student("Andrew", "Bykov", 23, 7.5));
        studentList.add(new Student("Olga", "Ivanova", 20, 8));

        // Посмотрим полученную коллекцию, используя итератор:
        Iterator<Student> iter = studentList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println();

        // Находим максимальный средний балл, используя итератор:
        double maxYearAverageMark = 0;
        Iterator<Student> iter2 = studentList.iterator();
        while(iter2.hasNext()){
            double yearAverageMark = iter2.next().getYearAverageMark();
            if (yearAverageMark > maxYearAverageMark) {
                maxYearAverageMark = yearAverageMark;
            }
        }
        System.out.println(maxYearAverageMark);

        // По полученному значению среднего балла находим студента(ов):
        for (Student item : studentList) {
            if (item.getYearAverageMark() == maxYearAverageMark) {
                System.out.println(item);
            }
        }
        System.out.println();

        // Выводим список учеников по полному имени (имя + фамилия), возрасту и среднему баллу, используя компараторы:
        for(Student s : studentList){
            System.out.println(s.getName() + " " + s.getSurname() + ", возраст  " + s.getAge()+ ", средний балл за год: " + s.getYearAverageMark());
        }
    }
}
