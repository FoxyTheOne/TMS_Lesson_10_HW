package com.tms.lesson10.prog04Garage.garage;

import com.tms.lesson10.prog04Garage.car.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Создать класс Garage, хранящий в себе HashMap автомобилей,
 * в котором ключом является объект автомобиля, значением - количество точно таких автомобилей в гараже.
 *
 * Добавить в класс Garage методы для парковки, выезда авто, а также для получения количества определенного вида автомобилей.
 */
public class Garage {
    private HashMap<Car, Integer> garageHashMap = new HashMap<>();
    // Если мы используем в качестве ключа наш собственный объект, он должен быть immutable + нужно переопределить хеш код в его классе

    public void parking(Car car, int sumOfCarsParking) {
        if (!garageHashMap.containsKey(car)) { // если такой машины в гараже ещё нет, добавляем в гараж передаваемое количество машин
            garageHashMap.put(car, sumOfCarsParking);
        }
        else {
            garageHashMap.replace(car, garageHashMap.get(car) + sumOfCarsParking); // если такие машины уже были, прибавляем передаваемое количество к тому, что уже записано
        }
        System.out.println("Припарковалось " + sumOfCarsParking + " " + car.getCarMark() + " " + car.getCarModel());
    }

    public  void leave(Car car, int sumOfCarsLeaving) {
        if(garageHashMap.containsKey(car)){
            int amountOfLeftCars = garageHashMap.get(car) - sumOfCarsLeaving;
            if (amountOfLeftCars >= 0) {
                garageHashMap.replace(car, amountOfLeftCars);
                System.out.println(sumOfCarsLeaving + " " + car.getCarMark() + " " + car.getCarModel() + " выехал(а) из гаража");
            } else {
                System.out.println("В гараже нет " + sumOfCarsLeaving + " " + car.getCarMark() + " " + car.getCarModel() + ". Попробуйте ввести команду ещё раз");
            }
        }
        else{
            garageHashMap.replace(car, 0); // Если таких машин в гараже ещё не было, они не могут уехать. Количество 0
            System.out.println(car.getCarMark() + " " + car.getCarModel() + " не может уехать, потому что такая машина в гараже ещё не парковалась. Попробуйте ввести команду ещё раз");
        }
    }

    public  void checkAmountByModel(String carModel) {
        int amountCarInGarage = 0;
        for(Map.Entry<Car, Integer> item : garageHashMap.entrySet()) { // for-each для Map
            if (item.getKey().getCarModel().equals(carModel)) {
                amountCarInGarage =  amountCarInGarage + item.getValue(); // item.getValue() - это количество одинаковых автомобилей в нашей коллекции
            }
        }
        if (amountCarInGarage > 0) {
            System.out.println("В гараже осталось " + amountCarInGarage + " " + carModel);
        } else {
            System.out.println("В гараже нет " + carModel);
        }
    }

    public HashMap<Car, Integer> getGarageHashMap() {
        return garageHashMap;
    }

}
