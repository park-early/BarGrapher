package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarTest {

    private Bar bar;

    @BeforeEach
    public void setup() {
        this.bar = new Bar("label", 10.0);
    }

    @Test
    public void testConstructor() {
        this.bar.setLength(10);
        assertEquals(10, this.bar.getLength());
        assertEquals(10.0, this.bar.getValue());
        assertEquals("label", this.bar.getLabel());
    }
}
