package model;

import java.util.HashMap;
import java.util.Set;

public class Graph {

    private HashMap<String, Bar> bars;

    //EFFECTS: constructs a blank graph
    public Graph() {
        this.bars = new HashMap<>();
    }

    //getters
    public HashMap<String, Bar> getBars() {
        return bars;
    }
    public Set<String> getLabels() {
        return this.bars.keySet();
    }

    //MODIFIES: this
    //EFFECTS: adds a bar to the graph
    public void addBar(String label, Bar bar) {
        this.bars.put(label, bar);
    }

    //MODIFIES: this
    //EFFECTS: removes a bar from the graph, does nothing if label is not there
    public void removeBar(String label) {
        this.bars.remove(label);
    }
}
