package Java.lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class lab2 {
    
    public static void main(String[] args) {
        Scanner systemIn = new Scanner(System.in);
        // Scanner systemInStrings = new Scanner(System.in);

        ArrayList<product> arrProducts = new ArrayList<>();
        
        while(true) {
            menuOutput();
            int choice = systemIn.nextInt();
            switch (choice) {
                case (1) :
                    makeProdRations(systemIn, arrProducts);
                    break;
                case (2) :
                    makeProdClothing(systemIn, arrProducts);
                    break;
                case (3) :
                    for (product p : arrProducts) {
                        p.dataOutput();
                        p.virtual();
                    }
                    break;
                case (4) :
                    menuChangeProps(systemIn, arrProducts);
                    break;
                case (5) :
                    double sum = 0;
                    for (product p : arrProducts) {
                        sum += p.cost;
                    }
                    System.out.println("Сумма покупок: " + sum);
                    break;
                case (6) :
                    System.out.println("Работа выполнена...");
                    return;
            }
        }
    }

    static void menuOutput() {
        System.out.println("================Выберите действие================");
        System.out.println("1. Создать новый класс товара");
        System.out.println("2. Создать новый класс одежды");
        System.out.println("3. Вывести экземпляры классов в массиве");
        System.out.println("4. Изменить свойства объекта в массиве");
        System.out.println("5. Вычислить сумму покупки");
        System.out.println("6. Выход");
        System.out.println("=================================================");
    }

    static void makeProdRations(Scanner systemInNumbers, ArrayList<product> arrProducts) {
        rations prodRations = new rations(systemInNumbers);
        arrProducts.add(prodRations);
    }

    static void makeProdClothing(Scanner systemInNumbers, ArrayList<product> arrProducts) {
        clothing prodClothing = new clothing(systemInNumbers);
        arrProducts.add(prodClothing);
    }

    static void menuChangeProps(Scanner systemInNumbers, ArrayList<product> arrProducts) {
        System.out.println("Выберите элемент массива 1 - " + arrProducts.size()+1);
        int choice = systemInNumbers.nextInt();
        if (choice > arrProducts.size() || choice < 0) {
            System.out.println("Ошибка выбора!");
            return;
        }

        if (arrProducts.get(choice - 1) instanceof rations) {
            System.out.println("Какое свойство объекта вы хотите изменить?");
            System.out.println("1. Стоимость");
            System.out.println("2. Марка");
            System.out.println("3. Тип продовольствия");
            System.out.println("4. Вес продовольствия");
            int choiceProp = systemInNumbers.nextInt();
            switch (choiceProp) {
                case (1) :
                    arrProducts.get(choice - 1).costInput(systemInNumbers);
                    break;
                case (2) :
                    arrProducts.get(choice - 1).mfrInput(systemInNumbers);
                    break;
                case (3) :
                    arrProducts.get(choice - 1).firstPropInput(systemInNumbers);
                    break;
                case (4) :
                    arrProducts.get(choice - 1).secondPropInput(systemInNumbers);
                    break;
            }
        }
        else if (arrProducts.get(choice - 1) instanceof clothing) {
            System.out.println("Какое свойство объекта вы хотите изменить?");
            System.out.println("1. Стоимость");
            System.out.println("2. Марка");
            System.out.println("3. Тип одежды");
            System.out.println("4. Цвет одежды");
            int choiceProp = systemInNumbers.nextInt();
            switch (choiceProp) {
                case (1) :
                    arrProducts.get(choice - 1).costInput(systemInNumbers);
                    break;
                case (2) :
                    arrProducts.get(choice - 1).mfrInput(systemInNumbers);
                    break;
                case (3) :
                    arrProducts.get(choice - 1).firstPropInput(systemInNumbers);
                    break;
                case (4) :
                    arrProducts.get(choice - 1).secondPropInput(systemInNumbers);
                    break;
            }
        }
    }
}