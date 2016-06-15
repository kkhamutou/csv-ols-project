package com.ols;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvAdapter {
    private static final String delimiter = ",";

    public static Dataset readCsv(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("File " + path + " does not exist");
        }
        Dataset dataset = null;
        List<Row> rows = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip headers
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(delimiter);
                Row row = new Row(values);
                rows.add(row);
            }
            dataset = new Dataset(path, rows);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static void saveCsv(String path, List<Dataset> datasets) {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            int maxSize = getMaxSize(datasets);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < datasets.size(); i++) {
                sb.append("Date")
                        .append(delimiter)
                        .append("Company name")
                        .append(delimiter)
                        .append("Change")
                        .append(delimiter)
                        .append(delimiter);
            }

            sb.append(System.lineSeparator());

            for (int i = 0; i < maxSize; i++) {
                StringBuilder line = new StringBuilder();
                for (Dataset ds : datasets) {
                    if (ds.getSize() > i) {
                        Row row = ds.getRows().get(i);
                        double change = (row.getClose() - row.getOpen()) / row.getOpen();
                        line.append(row.getDate())
                                .append(delimiter)
                                .append(ds.getName())
                                .append(delimiter)
                                .append(String.valueOf(change))
                                .append(delimiter);
                    } else {
                        line.append(delimiter)
                                .append(delimiter)
                                .append(delimiter);
                    }
                    line.append(delimiter);
                }
                line.append(System.lineSeparator());
                sb.append(line);
            }

            bw.write(sb.toString());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("File " + file + " successfully saved");
    }

    private static int getMaxSize(List<Dataset> datasets) {
        int max = 0;
        for (Dataset ds : datasets) {
            if (ds.getSize() > max) {
                max = ds.getSize();
            }
        }
        return max;
    }
}
