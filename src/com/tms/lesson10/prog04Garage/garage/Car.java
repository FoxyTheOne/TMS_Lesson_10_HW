package com.tms.lesson10.prog04Garage.garage;

import java.util.Objects;

/**
 *  4. Создать абстрактный класс Car, представляющий собой автомобиль.
 * 	Добавить в него поля: марка, модель, год выпуска + несколько своих.
 *
 * 	Создать 4 класса, являющихся наследниками Car.
 * 	Переопределить во всех 3-х классах методы equals(), hashCode() и toString()
 */
public abstract class Car {

    private final String carMark;
    private final String carModel;
    private final int yearOfProduction;
    private final String carColor;

    public Car(String carMark, String carModel, int yearOfProduction, String carColor) {
        this.carMark = carMark;
        this.carModel = carModel;
        this.yearOfProduction = yearOfProduction;
        this.carColor = carColor;
    }

    public String getCarMark() {
        return carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getCarColor() {
        return carColor;
    }
}
