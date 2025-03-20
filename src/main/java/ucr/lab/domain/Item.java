package ucr.lab.domain;

import ucr.lab.utility.util;

public class Item {
    private String name;
    private double value;
    private double weight;
    private double valueWeightRatio;
    private int stock;

    public double getValueWeightRatio() {
        return valueWeightRatio;
    }

    public void setValueWeightRatio() {
        this.valueWeightRatio = value / weight;
    }

    public Item(String name, double value, double weight, int stock) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.stock = stock;
        setValueWeightRatio();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        setValueWeightRatio();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        setValueWeightRatio();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
         return String.format("%20s, %12.2f, %12.2f, %12d", this.name, this.value, this.weight, this.stock);
    }
}
