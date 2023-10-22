package Java.lab2;

import java.util.Scanner;

class rations extends product {
    String typeOfFood;
    int weight;

    static void typeOfFoodInput(Scanner systemIn, String typeOfFood) {
        System.out.println("Введите тип продовольствия: ");
        typeOfFood = systemIn.next();
    }

    static void weightInput(Scanner systemIn, int weight) {
        System.out.println("Введите вес продовольствия: ");
        weight = systemIn.nextInt();
    }

    void dataOutput() {
        System.out.println("Тип продовольствия: " + typeOfFood);
        System.out.println("Вес продовольствия: " + weight);
    }

    void virtual() {
        System.out.println("Выполняется виртуальный метод класса rations");
    }
}