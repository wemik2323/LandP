package wemik2323;

import java.io.UnsupportedEncodingException;

public class Freezer extends Appliances {
    int mode;
    int status;
    String[] statuses = {"Охлаждает","Замораживает","Размораживает"};
    String[] modes = {"Обычная","Заморозка","Разморозка"};

    public Freezer(String modelName, String brandName) throws UnsupportedEncodingException {
        super(modelName, brandName);
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
            this.mode = choice - 1;
            this.status = choice - 1;
            return 0;
        }
    }
}
