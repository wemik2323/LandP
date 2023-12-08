package Java.lab5;

import java.io.UnsupportedEncodingException;

public class Washer extends Appliances {

    public Washer(String modelName, String brandName) throws UnsupportedEncodingException {
        super(modelName, brandName);
    }

    @Override
    public int changeMode(int mode) {
        if (decodeMode()!= "Unknown") {
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
                    statusDsc = "Default";
                    break;
                case 1:
                    statusDsc = "LilSpots";
                    break;
                case 2:
                    statusDsc = "ExtraSpots";
                    break;
                case 3: 
                    statusDsc = "DirtyHard";
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
                    statusDsc = "Watering";
                    break;
                case 1:
                    statusDsc = "Cleaning";
                    break;
                case 2:
                    statusDsc = "Squeezes";
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
    
}
