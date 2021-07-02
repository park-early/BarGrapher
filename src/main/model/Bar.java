package model;

public class Bar {

    private String label;
    private double value;
    private int length;

    //EFFECTS: constructs bar with length 0
    public Bar(String label, double value) {
        this.label = label;
        this.value = value;
        this.length = 0;
    }

    //getters
    public String getLabel() {
        return this.label;
    }
    public double getValue() {
        return this.value;
    }
    public int getLength() {
        return this.length;
    }

    //setters
    public void setLabel(String label) {
        this.label = label;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
