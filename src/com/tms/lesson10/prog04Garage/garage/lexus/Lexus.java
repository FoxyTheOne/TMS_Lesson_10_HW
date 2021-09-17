package com.tms.lesson10.prog04Garage.garage.lexus;

import com.tms.lesson10.prog04Garage.garage.Car;

/**
 * Переопределить во всех 3-х классах методы equals(), hashCode() и toString()
 */
public final class Lexus extends Car {

    public Lexus(String getCarMark, String carModel, int yearOfProduction, String carColor) {
        super(getCarMark, carModel, yearOfProduction, carColor);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Lexus{" +
                "carBrand='" + getCarMark() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", yearOfProduction=" + getYearOfProduction() +
                ", carColor='" + getCarColor() + '\'' +
                '}';
    }

}
