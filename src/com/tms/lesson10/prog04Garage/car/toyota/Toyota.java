package com.tms.lesson10.prog04Garage.car.toyota;

import com.tms.lesson10.prog04Garage.car.Car;

/**
 * Переопределить во всех 3-х классах методы equals(), hashCode() и toString()
 */
public final class Toyota extends Car {

    public Toyota(String getCarMark, String carModel, int yearOfProduction, String carColor) {
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
        return "Toyota{" +
                "carBrand='" + getCarMark() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", yearOfProduction=" + getYearOfProduction() +
                ", carColor='" + getCarColor() + '\'' +
                '}';
    }

}
