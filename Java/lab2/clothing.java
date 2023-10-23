package Java.lab2;

import java.util.Scanner;

class clothing extends product {
    String typeOfClothing;
    String color;

    clothing() {
        cost = 0;
        mfr = null;
        typeOfClothing = null;
        color = null;
    }

    clothing(Scanner systemIn) {
        System.out.println("Ввод clothing:");
        costInput(systemIn);
        mfrInput(systemIn);
        firstPropInput(systemIn);
        secondPropInput(systemIn);
    }

    void firstPropInput(Scanner systemIn) {
        System.out.println("Введите тип одежды: ");
        typeOfClothing = systemIn.nextLine();
    }

    void secondPropInput(Scanner systemIn) {
        System.out.println("Введите цвет одежды: ");
        color = systemIn.nextLine();
    }

    void dataOutput() {
        System.out.println("\nВывод данных одежды:");
        System.out.println("Цена одежды: " + cost);
        System.out.println("Марка одежды: " + mfr);
        System.out.println("Тип одежды: " + typeOfClothing);
        System.out.println("Цвет одежды: " + color);
    }

    void virtual() {
        System.out.println("Выполняется виртуальный метод класса clothing");
    }
}