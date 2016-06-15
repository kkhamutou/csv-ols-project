package com.ols;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // to run you need at least one input file with data and exactly one file for output
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Too few arguments!");
        }
        int size = args.length - 1; // the last element is the output file name
        String output = args[size];
        List<Dataset> datasets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Dataset dataset = CsvAdapter.readCsv(args[i]);
            datasets.add(dataset);
        }
        CsvAdapter.saveCsv(output, datasets);
    }
}