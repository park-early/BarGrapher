package model;

import model.exceptions.NegativeValue;

public class Bar {

    private double value;
    private int length;

    //EFFECTS: constructs bar with length 0
    public Bar(double value) throws NegativeValue {
        if (value < 0) {
            throw new NegativeValue();
        }
        this.value = value;
        this.length = 0;
    }

    //getters
    public double getValue() {
        return this.value;
    }
    public int getLength() {
        return this.length;
    }

    //setters
    public void setValue(double value) {
        this.value = value;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
