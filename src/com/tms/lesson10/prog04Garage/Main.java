package com.tms.lesson10.prog04Garage;

import com.tms.lesson10.prog04Garage.car.Car;
import com.tms.lesson10.prog04Garage.garage.Garage;
import com.tms.lesson10.prog04Garage.car.lexus.Lexus;
import com.tms.lesson10.prog04Garage.car.ford.Ford;
import com.tms.lesson10.prog04Garage.car.toyota.Toyota;
import com.tms.lesson10.prog04Garage.car.volkswagen.Volkswagen;

/**
 * Продемонстрировать работу гаража.
 */
public class Main {
    public static void main(String[] args) {
        Car lexusCt200h = new Lexus("Lexus", "ct200h", 2015, "red");
        Car fordFocus = new Ford("Ford", "Focus", 1995, "black");
        Car toyotaPicnic = new Toyota("Toyota", "Picnic", 1999, "black");
        Car volkswagenPolo = new Volkswagen("Volkswagen", "Polo", 2018, "yellow");
        Car toyotaPrius = new Toyota("Toyota", "Prius", 2020, "gray");

        // Создаём пустой гараж
        Garage garage = new Garage();
        System.out.println("Гараж пуст");

        // Проверяем, что он пустой
        garage.checkAmountByModel("Polo");
        System.out.println();

        // Паркуем машины
        garage.parking(fordFocus, 3);
        garage.parking(toyotaPicnic, 10);
        garage.parking(volkswagenPolo, 5);
        garage.parking(toyotaPrius, 1);
        garage.parking(toyotaPrius, 1);
        System.out.println();

        // Проверяем количество машин
        garage.checkAmountByModel("Focus");
        garage.checkAmountByModel("Picnic");
        garage.checkAmountByModel("Polo");
        garage.checkAmountByModel("Prius");
        garage.checkAmountByModel("111111111");
        System.out.println();

        // Машины уезжают из гаража + проверка
        garage.leave(toyotaPicnic, 2);
        garage.checkAmountByModel("Picnic");
        garage.leave(toyotaPicnic, 8);
        garage.checkAmountByModel("Picnic");
        System.out.println();

        garage.leave(toyotaPicnic, 1);
        garage.checkAmountByModel("Picnic");
        garage.leave(lexusCt200h,1);
        garage.checkAmountByModel("ct200h");
        System.out.println();

        System.out.println("Наш гараж (проверка):");
        System.out.println(garage.getGarageHashMap());
    }
}
