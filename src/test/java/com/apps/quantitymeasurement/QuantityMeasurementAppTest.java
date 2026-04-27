package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(1.0);

        assertEquals(first, second, "Feet values with the same numeric value should be equal");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet first = new Feet(1.0);
        Feet second = new Feet(2.0);

        assertNotEquals(first, second, "Feet values with different values should not be equal");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals(null), "Feet.equals(null) should return false");
    }

    @Test
    public void testFeetEquality_NonNumericInput() {
        Feet first = new Feet(1.0);

        assertFalse(first.equals("1.0"), "Feet should not equal a non-Feet object such as a string");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet first = new Feet(1.0);
        Feet sameReference = first;

        assertSame(first, sameReference, "The same object reference should be used for reflexivity");
        assertTrue(first.equals(sameReference), "Feet.equals should be reflexive when comparing the same reference");
    }
}
