package Java.lab3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lab3 {
    public static void main(String[] args) {
        String pathF = "C:/Users/Taiks/repositories/LandP/Java/lab3/f.txt";
        String pathN = "C:/Users/Taiks/repositories/LandP/Java/lab3/n.txt";
        String pathG = "C:/Users/Taiks/repositories/LandP/Java/lab3/g.txt";

        int[] list = null;
        try (BufferedReader file = new BufferedReader(new FileReader(pathF))){
            list = file.lines().mapToInt(Integer::parseInt).toArray();
        } catch (FileNotFoundException e) {
            System.out.println("ФАЙЛА НЕТУ!");
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
}