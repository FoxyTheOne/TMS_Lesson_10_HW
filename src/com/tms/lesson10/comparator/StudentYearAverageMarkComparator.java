package com.tms.lesson10.comparator;

import com.tms.lesson10.additTask.Student;

import java.util.Comparator;

public class StudentYearAverageMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getYearAverageMark(), o2.getYearAverageMark());
    }

}
