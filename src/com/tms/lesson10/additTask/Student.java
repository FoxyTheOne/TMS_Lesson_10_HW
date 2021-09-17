package com.tms.lesson10.additTask;

import java.util.Objects;

/**
 * Дополнительно
 * 0. Создать класс Student, представляющий собой ученика.
 * Добавить ему данные об имени, фамилии, возрасте и среднем балле за год.
 */
public class Student {
    private String name;
    private String surname;
    private int age;
    private double yearAverageMark;

    public Student() {
    }

    public Student(String name, String surname, int age, double yearAverageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.yearAverageMark = yearAverageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getYearAverageMark() {
        return yearAverageMark;
    }

    public void setYearAverageMark(double yearAverageMark) {
        this.yearAverageMark = yearAverageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.yearAverageMark, yearAverageMark) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, yearAverageMark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", yearAverageMark=" + yearAverageMark +
                '}';
    }
}
