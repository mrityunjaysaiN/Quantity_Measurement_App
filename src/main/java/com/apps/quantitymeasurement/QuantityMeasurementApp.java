package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static Length parseLength(String input, Length.LengthUnit unit) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Length unit must not be null");
        }
        try {
            return new Length(Double.parseDouble(input.trim()), unit);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input must be a numeric length value.", ex);
        }
    }

    public static Length parseLength(String input, String unitName) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        if (unitName == null) {
            throw new IllegalArgumentException("Unit name must not be null");
        }
        try {
            return new Length(Double.parseDouble(input.trim()), Length.LengthUnit.from(unitName));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input must be a numeric length value.", ex);
        }
    }

    public static boolean compareLengths(String firstValue,
                                         Length.LengthUnit firstUnit,
                                         String secondValue,
                                         Length.LengthUnit secondUnit) {
        return parseLength(firstValue, firstUnit).equals(parseLength(secondValue, secondUnit));
    }

    public static void demonstrateFeetEquality() {
        String firstValue = "1.0";
        String secondValue = "1.0";
        boolean result = compareLengths(firstValue, Length.LengthUnit.FEET, secondValue, Length.LengthUnit.FEET);
        System.out.printf("Input: Quantity(%s, \"feet\") and Quantity(%s, \"feet\")%nOutput: Equal (%b)%n",
                firstValue, secondValue, result);
    }

    public static void demonstrateInchesEquality() {
        String firstValue = "1.0";
        String secondValue = "1.0";
        boolean result = compareLengths(firstValue, Length.LengthUnit.INCHES, secondValue, Length.LengthUnit.INCHES);
        System.out.printf("Input: Quantity(%s, \"inch\") and Quantity(%s, \"inch\")%nOutput: Equal (%b)%n",
                firstValue, secondValue, result);
    }

    public static void demonstrateFeetInchesComparison() {
        String feetValue = "1.0";
        String inchesValue = "12.0";
        boolean result = compareLengths(feetValue, Length.LengthUnit.FEET, inchesValue, Length.LengthUnit.INCHES);
        System.out.printf("Input: Quantity(%s, \"feet\") and Quantity(%s, \"inches\")%nOutput: Equal (%b)%n",
                feetValue, inchesValue, result);
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
