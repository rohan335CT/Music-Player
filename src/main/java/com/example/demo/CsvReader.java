package com.example.demo;

import java.io.*;
import java.util.Scanner;

public class CsvReader implements FileReader {
    @Override
    public void read() {
        System.out.println("Reading from CSV file");
        Scanner sc;
        try {
            sc = new Scanner(new File("/Users/rohan.k/Documents/ClearPractice/Day7/MusicPlayer/src/main/java/com/example/demo/CsvDemo.csv"));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.print(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void write() {
        System.out.println("Writing to CSV file");

        String[][] data = {
                {"Name", "Age", "Country"},
                {"John", "25", "USA"},
                {"Alice", "30", "UK"},
                {"Bob", "22", "Canada"}
        };

        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("/Users/kunal.singh/Downloads/demo/src/main/java/csvDemo.csv"));
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {

                    writer.write(data[i][j]);
                    if (j < data[i].length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Data written successfully to CSV file");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while writing to TSV file: " + e.getMessage());
            }
        }
    }
}
