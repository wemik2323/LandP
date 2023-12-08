package Java.lab5;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        Scanner systemIn = new Scanner(System.in);
        ArrayList<Appliances> arrAppliances = new ArrayList<Appliances>();

        while(true) {
            menuOutput();
            int choice = readInt(systemIn);
            switch (choice) {
                case (1) :
                    makeProdRations(systemIn, arrProducts);
                    amountOfProducts++;
                    break;
                case (2) :
                    makeProdClothing(systemIn, arrProducts);
                    amountOfProducts++;
                    break;
                case (3) :
                    for (product p : arrProducts) {
                        p.dataOutput();
                        p.virtual();
                    }
                    System.out.println("Размер массива - " + amountOfProducts);
                    break;
                case (4) :
                    int flag = -1;
                    flag = deleteProduct(systemIn, arrProducts, amountOfProducts);
                    if (flag != -1) {arrProducts.remove(flag); amountOfProducts--;}
                    break;
                case (5) :
                    menuChangeProps(systemIn, arrProducts, amountOfProducts);
                    break;
                case (6) :
                    double sum = 0;
                    for (product p : arrProducts) {
                        sum += p.cost;
                    }
                    System.out.println("Сумма покупок: " + sum);
                    break;
                case (0) :
                    System.out.println("Работа выполнена...");
                    return;
            }
        }
    }

    static void menuOutput() {
        System.out.println("================Выберите действие================");
        System.out.println("1. Создать новый класс холодильника");
        System.out.println("2. Создать новый класс стиральной машины");
        System.out.println("2. Создать новый класс посудомоечной машины");
        System.out.println("3. Вывести экземпляры классов в массиве");
        System.out.println("4. Удалить продукт из массива");
        System.out.println("5. Изменить свойства объекта в массиве");
        System.out.println("6. Вычислить сумму покупки");
        System.out.println("0. Выход");
        System.out.println("=================================================");
    }

    static void makeAppFreezer(Scanner systemIn, ArrayList<Appliances> arrAppliances) throws UnsupportedEncodingException {
        if (systemIn.hasNextLine()) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Freezer appFreezer = new Freezer(model, brand);
            arrAppliances.add(appFreezer);
        }
    }

    static void makeAppWasher(Scanner systemIn, ArrayList<Appliances> arrAppliances) throws UnsupportedEncodingException {
        if (systemIn.hasNextLine()) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Washer appWasher = new Washer(model, brand);
            arrAppliances.add(appWasher);
        }
    }

    static void makeAppDishwasher(Scanner systemIn, ArrayList<Appliances> arrAppliances) throws UnsupportedEncodingException {
        if (systemIn.hasNextLine()) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Dishwasher appDishwasher = new Dishwasher(model, brand);
            arrAppliances.add(appDishwasher);
        }
    }
}
