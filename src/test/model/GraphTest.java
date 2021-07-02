package model;

import model.exceptions.NegativeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph graph;
    private Bar bar1;

    @BeforeEach
    public void setup() throws NegativeValue {
        this.graph = new Graph();
        this.bar1 = new Bar(1);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, this.graph.getLabels().size());
    }

    @Test
    public void testAddBar() {
        this.graph.addBar("label1", bar1);
        assertEquals(1, this.graph.getLabels().size());
        assertTrue(this.graph.getLabels().contains("label1"));
    }

    @Test
    public void testRemoveBar() {
        this.graph.addBar("label1", bar1);
        this.graph.removeBar("label1");
        assertEquals(0, this.graph.getLabels().size());
        assertFalse(this.graph.getLabels().contains("label1"));
    }

    @Test
    public void testRemoveBarNoLabel() {
        this.graph.addBar("label1", bar1);
        this.graph.removeBar("label2");
        assertEquals(1, this.graph.getLabels().size());
        assertTrue(this.graph.getLabels().contains("label1"));
        assertFalse(this.graph.getLabels().contains("label2"));
    }
}
