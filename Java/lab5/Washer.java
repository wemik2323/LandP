package Java.lab5;

import java.util.Random;
import java.util.Scanner;

public class Washer extends Appliances {
    long start;
    int loaded;
    int mode;
    int status;
    String[] statuses = {"Ожидает","Моет","Отжимает"};
    String[] modes = {"Смешанная","Детская","Спортивная одежда","Спортивная обувь","Быстрая"};

    public Washer(String modelName, String brandName) {
        super(modelName, brandName);
        Random rand = new Random();
        this.loaded = rand.nextInt(3);
        this.status = 0;
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
    
    public int changeMode(int choice) {
        if (this.status == 0) {
            if (choice > this.modes.length || choice <= 0) {
                return -1;
            } else {
                this.mode = choice-1;
                return 0;
            }
        } else {
            System.out.println("Устройство в работе!");
            return -1;
        }
    }

    public void startCleaning(long currentTimeSeconds, Scanner systemIn) {
        if (this.loaded >= 0) {
            if (this.status == 0 && this.loaded > 0) {
                this.start = System.currentTimeMillis()/1000;
                this.status = 1;
                this.loaded -= 1;
            } else if (currentTimeSeconds - this.start < 10) {
                this.status = 2;
            } else if (currentTimeSeconds - this.start < 20) {
                this.status = 0;
                this.start = 0;
            } else {
                cleanScreen();
                System.out.println("Нет ресурсов для начала стирки!");
                pressEnterToContinue(systemIn);
            }
        }
    }
    
}
