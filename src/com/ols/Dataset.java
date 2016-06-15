package com.ols;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    private String name;
    private List<Row> rows = new ArrayList<>();
    private int size;

    public Dataset(String name, List<Row> rows) {
        int dotIndex = name.lastIndexOf('.');
        this.name = name.substring(0, dotIndex);
        this.rows = rows;
        this.size = rows.size();
    }

    public String getName() {
        return name;
    }

    public List<Row> getRows() {
        return rows;
    }

    public int getSize() {
        return size;
    }
}