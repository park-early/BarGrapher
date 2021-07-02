package model;

import model.exceptions.NegativeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BarTest {

    private Bar bar;

    @BeforeEach
    public void setup() throws NegativeValue {
        this.bar = new Bar(10.0);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, this.bar.getLength());
        assertEquals(10.0, this.bar.getValue());
    }

    @Test
    public void testConstructorException() {
        try {
            Bar bar1 = new Bar(-10.0);
            fail("NegativeValue exception expected");
        } catch (NegativeValue e) {
            //pass
        }
    }
}
