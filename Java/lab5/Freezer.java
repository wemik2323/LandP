package Java.lab5;

import java.util.Random;
import java.util.Scanner;

public class Freezer extends Appliances {
    int loaded;
    int mode;
    int status;
    String[] statuses = {"Охлаждает","Замораживает","Размораживает"};
    String[] modes = {"Обычный","Заморозка","Разморозка"};

    public Freezer(String modelName, String brandName) {
        super(modelName, brandName);
        Random rand = new Random();
        this.loaded = rand.nextInt(20);
    }

    public void outputCurrentStatus() {
        if (this.oi == 1) {
            System.out.println("Устройство включено.");
            System.out.println("Текущий статус: " + statuses[this.status]);
            outputCurrentLoad();
        } else {
            System.out.println("Устройство выключено.");
        }
    }

    public void outputCurrentMode() {
        System.out.println("Текущий режим: " + modes[this.mode]);
    }

    public void outputCurrentLoad() {
        System.out.println("Текущее количество ресурсов: " + this.loaded);
    }

    public void outputAllModes() {
        for (int i = 0; i < modes.length; i++) {
            System.out.println(i+1 + ". " + modes[i]);
        }
    }

    public int takeProducts(int amount) {
        if (amount > this.loaded) {
            this.loaded = 0;
            return 1;
        } else {
            this.loaded -= amount;
            return 0;
        }
    }

    public int giveProducts(int amount, Scanner systemIn) {
        if (amount < 0) {
            cleanScreen();
            System.out.println("Ошибка ввода!");
            pressEnterToContinue(systemIn);
            return -1;
        } else {
            this.loaded += amount;
            return 0;
        }
    }

    public int changeMode(int choice) {
        if (choice > this.modes.length || choice <= 0) {
            return -1;
        } else {
            this.mode = choice - 1;
            this.status = choice - 1;
            return 0;
        }
    }
}
