package com.example.demo;

import java.io.*;
import java.util.Scanner;

public class TsvReader implements FileReader{
    @Override
    public void read() {
        System.out.println("Reading from TSV file");
        Scanner sc;
        try {
            sc = new Scanner(new File("/Users/rohan.k/Documents/ClearPractice/Day7/MusicPlayer/src/main/java/com/example/demo/TsvDemo.tsv"));
            sc.useDelimiter("\t");
            while (sc.hasNext()) {
                System.out.print(sc.next() + " ");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write() {
        System.out.println("Writing to TSV file");
        String[][] data = {
                {"Name", "Age", "Country"},
                {"John", "25", "USA"},
                {"Alice", "30", "UK"},
                {"Bob", "22", "Canada"}
        };

        FileWriter writer = null;
        try {

            writer = new FileWriter(new File("/Users/kunal.singh/Downloads/demo/src/main/java/tsvDemo.tsv"));

            for (String[] datum : data) {
                for (int j = 0; j < datum.length; j++) {

                    writer.write(datum[j]);
                    if (j < datum.length - 1) {
                        writer.write("\t");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Data written successfully to TSV file");

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
