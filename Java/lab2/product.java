package Java.lab2;

import java.util.Scanner;

abstract class product {
    double cost;
    String mfr;

    static void costInput(Scanner systemIn, double cost) {
        System.out.println("Введите стоимость товара: ");
        cost = systemIn.nextDouble();
    }

    static void mfrInput(Scanner systemIn, String mfr) {
        System.out.println("Введите марку товара: ");
        mfr = systemIn.next();
    }

    abstract void dataOutput();

    void virtual() {
        System.out.println("Выполняется виртуальный метод класса product");
    }
}
