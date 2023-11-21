package Java.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// CSV -> 1, 2, 3, 4, 5, 6, 7
//word, frequency, frequency%, mostFrequentWord, MostFrequentWordAmount, MostRareWord, MostRareWordAmount

public class lab4 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Введите минимум один аргумент!");
            return;
        }
        if (args.length > 0) {

            for (String filename: args) {
                if (filename.indexOf(".txt") == -1) {
                    if (args[1].indexOf(".csv") != -1) {
                        float amountOfWords = 0;
                        HashMap<String, Float> map = makeHashMap(args[0], (int)amountOfWords);
                        amountOfWords = map.get("AOW");
                        map.remove("AOW");
                        LinkedHashMap<String, Float> sortedMap = makeSortedMap(map);
                        float percentage = makeCsvFile(sortedMap, (int)amountOfWords, filename);
                        System.out.println(percentage);
                    }
                    if (args[1].indexOf(".json")!= -1) {
                        makeJsonFile();
                    }
                }
            }
        }

        return;
    }

    static HashMap<String, Float> makeHashMap(String pathTextFile, int amountOfWords) throws IOException {
        StringBuilder word = new StringBuilder();
        HashMap<String, Float> map = new HashMap<String, Float>();

        String text = new String ((Files.readAllBytes(Paths.get(pathTextFile))), "UTF-8");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > 47 && text.charAt(i) < 58 || text.charAt(i) > 64 && text.charAt(i) < 91 || text.charAt(i) > 96 && text.charAt(i) < 123 || 
            text.charAt(i) > 1039 && text.charAt(i) < 1104) {
                word.append(text.charAt(i));
                if (i == text.length() - 1) {
                    if (map.containsKey(word.toString())) {
                    map.put(word.toString(), map.get(word.toString()) + 1);
                    } else {
                        map.put(word.toString(), 1f);
                    }
                    amountOfWords++;
                }
            } else if (word.length() > 0) {
                if (map.containsKey(word.toString())) {
                    map.put(word.toString(), map.get(word.toString()) + 1);
                } else {
                    map.put(word.toString(), 1f);
                }
                word = new StringBuilder();
                amountOfWords++;
            }
        }
        map.put("AOW", (float)amountOfWords);
        return map;
    }

    static String getMinKey(HashMap<String, Float> map) {
        String minKey = null;
        for (java.util.Map.Entry<String, Float> entryLocal : map.entrySet()) {
            if (Collections.min(map.values()) == entryLocal.getValue()) {
                minKey = entryLocal.getKey();
            }
        }
        return minKey;
    }
    static String getMaxKey(HashMap<String, Float> map) {
        String maxKey = null;
        for (java.util.Map.Entry<String, Float> entryLocal : map.entrySet()) {
            if (Collections.max(map.values()) == entryLocal.getValue()) {
                maxKey = entryLocal.getKey();
            }
        }
        return maxKey;
    }

    static LinkedHashMap<String, Float> makeSortedMap(HashMap<String, Float> map) {
        ArrayList<Float> list = new ArrayList<>();
        LinkedHashMap<String, Float> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int i = list.size()-1; i > 0; i--) {
            for (java.util.Map.Entry<String, Float> entry : map.entrySet()) {
                if (entry.getValue().equals(list.get(i))) {
                    sortedMap.put(entry.getKey(), list.get(i));
                }
            }
        }
        return sortedMap;
    }

    static float makeCsvFile(LinkedHashMap<String, Float> sortedMap, int amountOfWords, String File) throws IOException {
        String pathCSVFILE = File;
        BufferedWriter csvWriter = new BufferedWriter(new FileWriter(pathCSVFILE));
        csvWriter.write("word;frequency;frequency%;mostFrequentWord;MostFrequentWordAmount;MostRareWord;MostRareWordAmount;\n");
        boolean flag = true;
        float percentage = 0;
        for (String key : sortedMap.keySet()) {
            percentage += sortedMap.get(key) * 100/amountOfWords;
            if (flag) {
                csvWriter.write(key + ";" + sortedMap.get(key) + ";" + sortedMap.get(key) * 100 / amountOfWords + ";" + getMaxKey(sortedMap) + ";" +
                Collections.max(sortedMap.values()) + ";" + getMinKey(sortedMap) + ";" + Collections.min(sortedMap.values()) + "\n");

                flag = false;
                continue;
            }
            csvWriter.write(key + ";" + sortedMap.get(key) + ";" + sortedMap.get(key) * 100 / amountOfWords + "\n");
        }
        csvWriter.close();
        return percentage;
    }

    static void makeJsonFile() {

    }
}
