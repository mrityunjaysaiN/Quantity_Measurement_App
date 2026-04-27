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

    public static void demonstrateYardsEquality() {
        String firstValue = "2.0";
        String secondValue = "2.0";
        boolean result = compareLengths(firstValue, Length.LengthUnit.YARDS, secondValue, Length.LengthUnit.YARDS);
        System.out.printf("Input: Quantity(%s, \"yards\") and Quantity(%s, \"yards\")%nOutput: Equal (%b)%n",
                firstValue, secondValue, result);
    }

    public static void demonstrateCentimetersEquality() {
        String firstValue = "2.0";
        String secondValue = "2.0";
        boolean result = compareLengths(firstValue, Length.LengthUnit.CENTIMETERS, secondValue, Length.LengthUnit.CENTIMETERS);
        System.out.printf("Input: Quantity(%s, \"centimeters\") and Quantity(%s, \"centimeters\")%nOutput: Equal (%b)%n",
                firstValue, secondValue, result);
    }

    public static void demonstrateYardToFeetComparison() {
        String yardValue = "1.0";
        String feetValue = "3.0";
        boolean result = compareLengths(yardValue, Length.LengthUnit.YARDS, feetValue, Length.LengthUnit.FEET);
        System.out.printf("Input: Quantity(%s, \"yards\") and Quantity(%s, \"feet\")%nOutput: Equal (%b)%n",
                yardValue, feetValue, result);
    }

    public static void demonstrateYardToInchesComparison() {
        String yardValue = "1.0";
        String inchesValue = "36.0";
        boolean result = compareLengths(yardValue, Length.LengthUnit.YARDS, inchesValue, Length.LengthUnit.INCHES);
        System.out.printf("Input: Quantity(%s, \"yards\") and Quantity(%s, \"inches\")%nOutput: Equal (%b)%n",
                yardValue, inchesValue, result);
    }

    public static void demonstrateCentimeterToInchesComparison() {
        String centimeterValue = "1.0";
        String inchesValue = "0.393701";
        boolean result = compareLengths(centimeterValue, Length.LengthUnit.CENTIMETERS, inchesValue, Length.LengthUnit.INCHES);
        System.out.printf("Input: Quantity(%s, \"centimeters\") and Quantity(%s, \"inches\")%nOutput: Equal (%b)%n",
                centimeterValue, inchesValue, result);
    }

    public static void demonstrateCentimeterToFeetComparison() {
        String centimeterValue = "1.0";
        String feetValue = "0.032808";
        boolean result = compareLengths(centimeterValue, Length.LengthUnit.CENTIMETERS, feetValue, Length.LengthUnit.FEET);
        System.out.printf("Input: Quantity(%s, \"centimeters\") and Quantity(%s, \"feet\")%nOutput: Equal (%b)%n",
                centimeterValue, feetValue, result);
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateYardsEquality();
        demonstrateCentimetersEquality();
        demonstrateYardToFeetComparison();
        demonstrateYardToInchesComparison();
        demonstrateCentimeterToInchesComparison();
        demonstrateCentimeterToFeetComparison();
    }
}
