package com.ols;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pk on 6/15/16.
 */
public class CsvAdapter {
    public static List<Row> readCsv(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("File " + path + " does not exist");
        }
        List<Row> rows = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip headers
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                Row row = new Row(values);
                rows.add(row);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }
}
