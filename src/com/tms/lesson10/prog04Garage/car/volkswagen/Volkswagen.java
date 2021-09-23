package com.tms.lesson10.prog04Garage.car.volkswagen;

import com.tms.lesson10.prog04Garage.car.Car;

/**
 * Переопределить во всех 3-х классах методы equals(), hashCode() и toString()
 */
public final class Volkswagen extends Car {

    public Volkswagen(String carMark, String carModel, int yearOfProduction, String carColor) {
        super(carMark, carModel, yearOfProduction, carColor);
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
        return "Volkswagen{" +
                "carBrand='" + getCarMark() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", yearOfProduction=" + getYearOfProduction() +
                ", carColor='" + getCarColor() + '\'' +
                '}';
    }

}
