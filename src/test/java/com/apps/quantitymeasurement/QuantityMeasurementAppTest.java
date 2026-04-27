package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

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
    public void testFeetEquality_DifferentClass() {
        Feet first = new Feet(1.0);
        Inches other = new Inches(1.0);

        assertFalse(first.equals(other), "Feet should not be equal to an Inches object");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet first = new Feet(1.0);
        Feet sameReference = first;

        assertSame(first, sameReference, "The same object reference should be used for reflexivity");
        assertTrue(first.equals(sameReference), "Feet.equals should be reflexive when comparing the same reference");
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(1.0);

        assertEquals(first, second, "Inches values with the same numeric value should be equal");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches first = new Inches(1.0);
        Inches second = new Inches(2.0);

        assertNotEquals(first, second, "Inches values with different values should not be equal");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches first = new Inches(1.0);

        assertFalse(first.equals(null), "Inches.equals(null) should return false");
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches first = new Inches(1.0);
        Feet other = new Feet(1.0);

        assertFalse(first.equals(other), "Inches should not be equal to a Feet object");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches first = new Inches(1.0);
        Inches sameReference = first;

        assertSame(first, sameReference, "The same object reference should be used for reflexivity");
        assertTrue(first.equals(sameReference), "Inches.equals should be reflexive when comparing the same reference");
    }
}
