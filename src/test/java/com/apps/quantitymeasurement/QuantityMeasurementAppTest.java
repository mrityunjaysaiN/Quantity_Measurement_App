package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length first = new Length(1.0, Length.LengthUnit.FEET);
        Length second = new Length(1.0, Length.LengthUnit.FEET);

        assertEquals(first, second, "Quantity objects with the same feet value should be equal");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length first = new Length(1.0, Length.LengthUnit.INCHES);
        Length second = new Length(1.0, Length.LengthUnit.INCHES);

        assertEquals(first, second, "Quantity objects with the same inch value should be equal");
    }

    @Test
    public void testEquality_FeetToInches_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertEquals(feet, inches, "1 foot should be equal to 12 inches");
        assertEquals(inches, feet, "Equality should be symmetric across units");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length first = new Length(1.0, Length.LengthUnit.FEET);
        Length second = new Length(2.0, Length.LengthUnit.FEET);

        assertNotEquals(first, second, "Different feet quantities should not be equal");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length first = new Length(1.0, Length.LengthUnit.INCHES);
        Length second = new Length(2.0, Length.LengthUnit.INCHES);

        assertNotEquals(first, second, "Different inch quantities should not be equal");
    }

    @Test
    public void testEquality_SameReference() {
        Length first = new Length(1.0, Length.LengthUnit.FEET);
        Length sameReference = first;

        assertSame(first, sameReference, "The same object reference should be used for reflexivity");
        assertTrue(first.equals(sameReference), "A length should equal itself");
    }

    @Test
    public void testEquality_NullComparison() {
        Length first = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(first.equals(null), "Length.equals(null) should return false");
    }

    @Test
    public void testEquality_InvalidUnit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> QuantityMeasurementApp.parseLength("1.0", "yards"));

        assertTrue(exception.getMessage().contains("Unsupported length unit"));
    }

    @Test
    public void testEquality_NullUnit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> QuantityMeasurementApp.parseLength("1.0", (String) null));

        assertTrue(exception.getMessage().contains("Unit name must not be null"));
    }
}
