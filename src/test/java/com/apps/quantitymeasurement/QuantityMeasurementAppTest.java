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
    public void testEquality_YardToYard_SameValue() {
        Length first = new Length(1.0, Length.LengthUnit.YARDS);
        Length second = new Length(1.0, Length.LengthUnit.YARDS);

        assertEquals(first, second, "Quantity objects with the same yard value should be equal");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length first = new Length(1.0, Length.LengthUnit.YARDS);
        Length second = new Length(2.0, Length.LengthUnit.YARDS);

        assertNotEquals(first, second, "Different yard quantities should not be equal");
    }

    @Test
    public void testEquality_FeetToInches_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertEquals(feet, inches, "1 foot should be equal to 12 inches");
        assertEquals(inches, feet, "Equality should be symmetric across units");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        assertEquals(yard, feet, "1 yard should be equal to 3 feet");
        assertEquals(feet, yard, "Equality should be symmetric across yards and feet");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(yard, inches, "1 yard should be equal to 36 inches");
        assertEquals(inches, yard, "Equality should be symmetric across yards and inches");
    }

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        Length first = new Length(2.0, Length.LengthUnit.CENTIMETERS);
        Length second = new Length(2.0, Length.LengthUnit.CENTIMETERS);

        assertEquals(first, second, "Quantity objects with the same centimeter value should be equal");
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        Length centimeters = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);

        assertEquals(centimeters, inches, "1 centimeter should be equal to 0.393701 inches");
        assertEquals(inches, centimeters, "Equality should be symmetric across centimeters and inches");
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Length centimeters = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        assertNotEquals(centimeters, feet, "1 centimeter should not be equal to 1 foot");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(yard, feet, "Yard and feet should be equal");
        assertEquals(feet, inches, "Feet and inches should be equal");
        assertEquals(yard, inches, "Yard and inches should be transitive and equal");
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
                () -> QuantityMeasurementApp.parseLength("1.0", "stones"));

        assertTrue(exception.getMessage().contains("Unsupported length unit"));
    }

    @Test
    public void testEquality_NullUnit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> QuantityMeasurementApp.parseLength("1.0", (String) null));

        assertTrue(exception.getMessage().contains("Unit name must not be null"));
    }

    @Test
    public void testEquality_UnitAliasParsing() {
        Length yardWithAlias = QuantityMeasurementApp.parseLength("1.0", "yd");
        Length oneYard = new Length(1.0, Length.LengthUnit.YARDS);

        assertEquals(oneYard, yardWithAlias, "Alias parsing should interpret 'yd' as yards");
    }

    @Test
    public void testConversion_FeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result, 1e-6);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(2.0, result, 1e-6);
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        assertEquals(36.0, result, 1e-6);
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(1.0, result, 1e-6);
    }

    @Test
    public void testConversion_FeetToYards() {
        double result = Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(0.0, result, 1e-6);
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(-12.0, result, 1e-6);
    }

    @Test
    public void testConversion_RoundTripPreservesValue() {
        double original = 5.0;
        double converted = Length.convert(original, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double roundTrip = Length.convert(converted, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(original, roundTrip, 1e-6);
    }

    @Test
    public void testConversion_SameUnitReturnsSameValue() {
        double result = Length.convert(7.0, Length.LengthUnit.YARDS, Length.LengthUnit.YARDS);
        assertEquals(7.0, result, 1e-6);
    }

    @Test
    public void testConversion_NaNOrInfiniteThrows() {
        assertThrows(IllegalArgumentException.class, () -> Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () -> Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () -> Length.convert(1.0, null, Length.LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () -> Length.convert(1.0, Length.LengthUnit.FEET, null));
    }
}
