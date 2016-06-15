package com.ols;

public class Row {
    private static int SIZE = 7;
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double adjClose;

    public Row(String[] values) {
        if (values.length != SIZE) {
            throw new RuntimeException("Input data has wrong structure");
        }
        this.date = values[0];
        this.open = Double.parseDouble(values[1]);
        this.high = Double.parseDouble(values[2]);
        this.low = Double.parseDouble(values[3]);
        this.close = Double.parseDouble(values[4]);
        this.volume = Double.parseDouble(values[5]);
        this.adjClose = Double.parseDouble(values[6]);
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public double getVolume() {
        return volume;
    }

    public double getAdjClose() {
        return adjClose;
    }

    @Override
    public String toString() {
        return "Row{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", adjClose=" + adjClose +
                '}';
    }
}
