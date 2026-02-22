import java.io.*;
import java.util.*;

public class TotalSales {
    public static void main(String[] args) {
        String inputFile = "/Users/sophiapchung/Desktop/CSC369/lab1/sales.txt";
        String outputFile = "/Users/sophiapchung/Desktop/CSC369/lab2/total_sales.txt";

        // hashmap to store total sales for each day
        Map<String, Integer> salesByDay = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String date = parts[1];

                salesByDay.put(date, salesByDay.getOrDefault(date, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort by date
        List<Map.Entry<String, Integer>> sortedSales = new ArrayList<>(salesByDay.entrySet());
        Collections.sort(sortedSales, Comparator.comparing(Map.Entry::getKey));

        // write to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : sortedSales) {
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
