package Java.lab3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class lab3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner systemIn = new Scanner(System.in);
        String pathF = "C:/Users/Taiks/repositories/LandP/Java/lab3/f.txt";
        String pathN = "C:/Users/Taiks/repositories/LandP/Java/lab3/n.txt";
        String pathG = "C:/Users/Taiks/repositories/LandP/Java/lab3/g.txt";
        while(true) {
            menuOutput();
            int choice = getInt(systemIn);
            switch (choice) {
                case 1:
                System.out.printf("\033[2J");
                System.out.println("Вывод файла F");
                fileOutput(pathF, systemIn);
                    break;
                case 2:
                System.out.printf("\033[2J");
                System.out.println("Вывод файла N");
                fileOutput(pathN, systemIn);
                    break;
                case 3:
                System.out.printf("\033[2J");
                System.out.println("Вывод файла G");
                fileOutput(pathG, systemIn);
                    break;
                case 4:
                loadingScreen();
                task1(pathF, pathN, pathG);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                System.out.printf("\033[2J");
                System.out.println("Выберите существующее действие!");
                TimeUnit.SECONDS.sleep(1);
                    break;
            }
        }


    }

    static void menuOutput() {
        System.out.printf("\033[2J");
        System.out.println("================Выберите действие================");
        System.out.println("1. Вывести на экран файл F");
        System.out.println("2. Вывести на экран файл N");
        System.out.println("3. Вывести на экран файл G");
        System.out.println("4. Выполнить задание 1");
        System.out.println("5. Выполнить задание 2");
        System.out.println("6. Выход");
    }

    static void fileOutput(String path, Scanner systemIn) throws InterruptedException {
        int[] list = null;
        try (BufferedReader file = new BufferedReader(new FileReader(path))){
            list = file.lines().mapToInt(Integer::parseInt).toArray();
            for (var i: list) {
                System.out.print(i + " ");
            }
            pressEnterToContinue(systemIn);
        } catch (FileNotFoundException e) {
            System.out.println("Данного файла не существует.");
            TimeUnit.SECONDS.sleep(1);
            return;
        } catch (IOException e) {
            e.getMessage();
        }
    }

    static void task1(String pathF, String pathN, String pathG) throws InterruptedException {
        int[] list = null;
        try (BufferedReader file = new BufferedReader(new FileReader(pathF))){
            list = file.lines().mapToInt(Integer::parseInt).toArray();
        } catch (FileNotFoundException e) {
            System.out.println("Файла F не существует! Проверьте задание!");
            TimeUnit.SECONDS.sleep(1);
            return;
        } catch (IOException e) {
            e.getMessage();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathN))) {  
            for (var i: list) {
                if (i > 0) {
                out.append(String.valueOf(i));
                out.append("\n");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        int[] listPositive = null;
        try (BufferedReader file = new BufferedReader(new FileReader(pathN))){
            listPositive = file.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.getMessage();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathG))) {
            int count = 0;  
            for (var i: list) {
                if (i < 0) {
                out.append(String.valueOf(i));
                out.append("\n");
                out.append(String.valueOf(listPositive[count]));
                out.append("\n");
                count++;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    static void task2 (String pathF, String pathN, String pathG) throws InterruptedException {
        ArrayList<football> footballList = new ArrayList<football>();
        try (BufferedInputStream file = new BufferedInputStream(new FileInputStream(pathF))) {
            while (file.available() > 0) {
                football player = new football();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла football.txt не существует! Проверьте задание!");
            TimeUnit.SECONDS.sleep(1);
            return;
        } catch (IOException e) {
            e.getMessage();
        }
    }

    static int getInt(Scanner systemIn) throws InterruptedException {
        if (systemIn.hasNextInt()) {
            int nextInt = systemIn.nextInt();
            systemIn.nextLine();
            return nextInt;
        } else {
            System.out.printf("\033[2J");
            System.out.println("Ошибка ввода! Введите число.");
            TimeUnit.SECONDS.sleep(1);
            systemIn.nextLine();
        }
        return 7;
    }

    static void pressEnterToContinue(Scanner systemIn)
    { 
        System.out.println("\nНажмите Enter чтобы продолжить...");
        try {
            System.in.read();
            systemIn.nextLine();
        } catch(Exception e) {}  
    }

    static void loadingScreen() throws InterruptedException {
        System.out.printf("\033[2J");
        for (int i = 0; i < 6; i++) {
            System.out.print("\\ Загрузка \\\r");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print("| Загрузка |\r");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print("/ Загрузка /\r");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.print("- Загрузка -\r");
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}