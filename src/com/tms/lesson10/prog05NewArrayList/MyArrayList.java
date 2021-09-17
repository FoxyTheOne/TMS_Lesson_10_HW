package com.tms.lesson10.prog05NewArrayList;

import java.util.Arrays;

/**
 *  5. Представим, что в Java нет коллекции типа ArrayList.
 *	Создать свой класс, симулирующий работу класса динамической коллекции - т.е. создать свою кастомную коллекцию.
 *
 *  В основе коллекции будет массив.
 *  Кастомная коллекция должна хранить элементы разных классов(т.е. это generic).
 *
 *  Предусмотреть операции добавления элемента, удаления элемента, получение элемента по индексу, проверка есть ли элемент в коллекции, метод очистки все коллеции.
 *  Предусмотреть конструктор без параметров - создает массив размером по умолчанию.
 *  Предусмотреть конструктор с задаваемым размером внутреннего массива.
 *	Предусмотреть возможность автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена.
 */
public class MyArrayList<S> {
    // Поля
    transient Object[] elementData; // non-private to simplify nested class access
    private static final Object[] EMPTY_ELEMENTDATA = {}; // Пустой массив объектов, который создается при указании количества ячеек 0
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity]; // Если вводим размер NewArrayList > 0, создается массив объектов с таким количеством ячеек
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA; // Создаём пустой массив
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    // Предусмотреть конструктор без параметров - создает массив размером по умолчанию
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // 1. Добавление элемента
    public void addElement(S element) {

        arrayGrowIfNeeded();

        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] != null) {
                continue;
            } else {
                elementData[i] = element;
                break;
            }
        }

    }

    // 2. Удаление элемента:
    public void removeElement(int index) {
        // Создаём массив, в который запишем новые значения:
        Object[] newElementData = new Object[elementData.length - 1];

        // Записываем в новый массив все значения, не равные удаляемому элементу:
        int indexOfNewElementData = 0;
        for (int i = 0; i < elementData.length; i++) {
            if (i == index) {
                continue;
            }
            newElementData[indexOfNewElementData] = elementData[i];
            indexOfNewElementData++;
        }

        // Заменяем массив
        elementData = newElementData;
    }

    // 3. Получение элемента по индексу:
    public S getElement(int index) {
        S element = null;

        for (int i = 0; i < elementData.length; i++) {
            if (i == index) {
                element = (S) elementData[i];
                break;
            }
        }

        return element;
    }

    // 4. Проверка, есть ли элемент в коллекции:
    public boolean elementExists(S element) {
        for (Object item : elementData) {
            if (item != null && item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // 5. Метод очистки всей коллекции:
    public void clearAll() {
        int capacity = elementData.length;
        Object[] newElementData = new Object[capacity];
        elementData = newElementData;
    }

    // Предусмотреть возможность автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена
    private void arrayGrowIfNeeded() {
        int countEmptyCells = 0;
        for (Object item : elementData) {
            if (item != null) {
                continue;
            } else {
                countEmptyCells++;
            }
        }

        if (countEmptyCells < 1) {
            int capacity = elementData.length;
            capacity = capacity + 5;
            Object[] newElementData = new Object[capacity];

            int indexOfNewElementData = 0;
            for (Object item : elementData) {
                newElementData[indexOfNewElementData] = item;
                indexOfNewElementData++;
            }

            elementData = newElementData;
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
