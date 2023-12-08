package Java.lab5;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public abstract class Appliances {
    private String UUID;
    protected String modelName;
    protected String brandName;
    protected int mode;
    protected int status;

    public Appliances(String modelName, String brandName) throws UnsupportedEncodingException {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        this.UUID = new String(array, "UTF-8");
        this.modelName = modelName;
        this.brandName = brandName;
        this.mode = 0;
    }

    public void toggle() {
        if (mode == 1) {
            mode = 0;
        } else {
            mode = 1;
        }
    }

    abstract public int changeMode(int mode);

    public void currentStatus(String mode, String status) {
        System.out.println("Model name: " + this.modelName);
        System.out.println("Brand name: " + this.brandName);
        System.out.println("Mode: " + mode);
        System.out.println("Status: " + status);
    }

    abstract public String decodeMode();

    abstract public String decodeStatus();

    public String getModelName() {
        return modelName;
    }
    public String getBrandName() {
        return brandName;
    }
    public int getMode() {
        return mode;
    }
    public int getStatus() {
        return status;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
