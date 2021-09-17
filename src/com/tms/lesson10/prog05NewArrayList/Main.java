package com.tms.lesson10.prog05NewArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Создание коллекции по конструктору с параметрами и без:");
            MyArrayList<String> myArrayList = new MyArrayList<>(5);
            MyArrayList<String> myArrayList1 = new MyArrayList<>();
            System.out.println(myArrayList);
            System.out.println(myArrayList1);
            System.out.println();

            System.out.println("Проверка добавления элементов:");
            myArrayList.addElement("111");
            myArrayList.addElement("222");
            myArrayList.addElement("333");
            System.out.println(myArrayList);
            myArrayList.addElement("444");
            myArrayList.addElement("555");
            System.out.println(myArrayList);
            System.out.println();

            myArrayList.addElement("666");
            System.out.println(myArrayList);
            myArrayList.addElement("777");
            myArrayList.addElement("888");
            myArrayList.addElement("999");
            myArrayList.addElement("000");
            System.out.println(myArrayList);
            System.out.println();

            System.out.println("Проверка удаления элемента:");
            myArrayList.removeElement(1);
            System.out.println(myArrayList);
            System.out.println();

            System.out.println("Получение элемента по индексу:");
            System.out.println(myArrayList.getElement(0));
            System.out.println();

            System.out.println("Проверка, есть ли элемент в коллекции:");
            System.out.println(myArrayList.elementExists("111"));
            System.out.println(myArrayList.elementExists("000"));
            System.out.println(myArrayList.elementExists("qqqW"));
            System.out.println();

            System.out.println("Очистить всю коллекцию:");
            System.out.println(myArrayList);
            myArrayList.clearAll();
            System.out.println(myArrayList);
            System.out.println();

        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Перехваченное исключение - " + e1);
        } catch (IllegalArgumentException e2) {
            System.out.println("Перехваченное исключение - " + e2);
        }

    }
}
