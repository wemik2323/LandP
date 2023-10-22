package Java.lab2;

import java.util.Scanner;

class clothing extends product {
    String typeOfClothing;
    String color;

    static void typeOfClothingInput(Scanner systemIn, String typeOfClothing) {
        System.out.println("Введите тип одежды: ");
        typeOfClothing = systemIn.next();
    }

    static void colorInput(Scanner systemIn, String color) {
        System.out.println("Введите цвет одежды: ");
        color = systemIn.next();
    }

    void dataOutput() {
        System.out.println("Тип одежды: " + typeOfClothing);
        System.out.println("Цвет одежды: " + color);
    }

    void virtual() {
        System.out.println("Выполняется виртуальный метод класса clothing");
    }
}