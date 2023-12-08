package Java.lab5;

import java.io.UnsupportedEncodingException;

public class Freezer extends Appliances {

    public Freezer(String modelName, String brandName) throws UnsupportedEncodingException {
        super(modelName, brandName);
    }

    @Override
    public int changeMode(int mode) {
        if (decodeMode() != "Unknown") {
            this.mode = mode;
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String decodeMode() {
        String statusDsc;
        if (mode != 0) {
            switch(this.status) {
                case 0:
                    statusDsc = "Cooling";
                    break;
                case 1:
                    statusDsc = "Freezing";
                    break;
                case 2:
                    statusDsc = "Heating";
                    break;
                default: 
                    statusDsc = "Unknown";
                    break;
            }
            return statusDsc;
        } else {
            return "Off";
        }
    }

    @Override
    public String decodeStatus() {
        String statusDsc;
        if (mode != 0) {
            switch(this.status) {
                case 0:
                    statusDsc = "OverFreezing";
                    break;
                case 1:
                    statusDsc = "OverHeating";
                    break;
                default: 
                    statusDsc = "Working";
                    break;
            }
            return statusDsc;
        } else {
            return "Off";
        }
    }
}
