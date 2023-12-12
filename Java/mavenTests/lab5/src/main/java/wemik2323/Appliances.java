package wemik2323;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public abstract class Appliances {
    private String UUID;
    protected String modelName;
    protected String brandName;
    protected int oi = 0;

    public Appliances(String modelName, String brandName) throws UnsupportedEncodingException {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String randomString = "";
        Random rand = new Random();

        char[] id = new char[8];

        for (char c : id) {
            c = characters.charAt(rand.nextInt(characters.length()));
            randomString += c;
        }
        
        this.UUID = randomString;
        this.modelName = modelName;
        this.brandName = brandName;
        this.oi = 0;
    }

    public void toggle() {
        if (oi == 1) {
            oi = 0;
        } else {
            oi = 1;
        }
    }

    abstract int changeMode(int choice);
    abstract void outputCurrentMode();
    abstract void outputCurrentStatus();
    abstract void outputAllModes();

    public String getModelName() {
        return this.modelName;
    }
    public String getBrandName() {
        return this.brandName;
    }
    public int getOi() {
        return this.oi;
    }
    public String getUUID() {
        return this.UUID;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setOi(int mode) {
        this.oi = mode;
    }
}
