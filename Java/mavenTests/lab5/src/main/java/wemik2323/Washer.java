package wemik2323;

import java.io.UnsupportedEncodingException;

public class Washer extends Appliances {
    long start;
    int mode;
    int status;
    String[] statuses = {"Ожидает","Моет","Отжимает"};
    String[] modes = {"Смешанная","Детская","Спортивная одежда","Спортивная обувь","Быстрая"};

    public Washer(String modelName, String brandName) throws UnsupportedEncodingException {
        super(modelName, brandName);
        this.status = 0;
    }

    public void outputCurrentStatus() {
        System.out.println("Текущий статус: " + statuses[this.status]);
    }

    public void outputCurrentMode() {
        System.out.println("Текущий режим: " + modes[this.mode]);
    }

    public void outputAllModes() {
        for (int i = 0; i < modes.length; i++) {
            System.out.println(i+1 + ". " + modes[i]);
        }
    }
    
    public int changeMode(int choice) {
        if (choice > this.modes.length || choice < 0) {
            return -1;
        } else {
            this.mode = choice-1;
            return 0;
        }
    }

    public void startCleaning(long currentTimeSeconds) {
        if (this.status == 0) {
            this.start = System.currentTimeMillis()/1000;
            this.status = 1;
        } else if (currentTimeSeconds - this.start < 10) {
            this.status = 2;
        } else if (currentTimeSeconds - this.start < 20) {
            this.status = 0;
            this.start = 0;
        }
    }
}
