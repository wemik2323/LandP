package Java.lab2;

import java.util.Scanner;

abstract class product {
    double cost;
    String mfr;

    product() {
        cost = 0;
        mfr = null;
    }

    product(Scanner systemIn) {
        costInput(systemIn);
        mfrInput(systemIn);
    }

    void costInput(Scanner systemIn) {
        System.out.println("Введите стоимость товара: ");
        cost = systemIn.nextDouble();
        systemIn.nextLine();
    }

    void mfrInput(Scanner systemIn) {
        System.out.println("Введите марку товара: ");
        mfr = systemIn.nextLine();
    }

    abstract void dataOutput();

    abstract void firstPropInput(Scanner systemIn);

    abstract void secondPropInput(Scanner systemIn);

    void virtual() {
        System.out.println("Выполняется виртуальный метод класса product");
    }
}
