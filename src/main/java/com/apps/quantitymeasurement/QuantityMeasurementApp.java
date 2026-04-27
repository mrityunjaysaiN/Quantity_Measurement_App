package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Feet other = (Feet) obj;
            return Double.compare(value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Inches other = (Inches) obj;
            return Double.compare(value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static Feet parseFeet(String input) {
        Objects.requireNonNull(input, "Input must not be null");
        try {
            return new Feet(Double.parseDouble(input.trim()));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input must be a numeric feet value.", ex);
        }
    }

    public static Inches parseInches(String input) {
        Objects.requireNonNull(input, "Input must not be null");
        try {
            return new Inches(Double.parseDouble(input.trim()));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input must be a numeric inches value.", ex);
        }
    }

    public static boolean compareFeet(String firstInput, String secondInput) {
        return parseFeet(firstInput).equals(parseFeet(secondInput));
    }

    public static boolean compareInches(String firstInput, String secondInput) {
        return parseInches(firstInput).equals(parseInches(secondInput));
    }

    public static void demonstrateFeetEquality() {
        String firstValue = "1.0";
        String secondValue = "1.0";
        boolean result = compareFeet(firstValue, secondValue);
        System.out.printf("Input: %s ft and %s ft%nOutput: Equal (%b)%n", firstValue, secondValue, result);
    }

    public static void demonstrateInchesEquality() {
        String firstValue = "1.0";
        String secondValue = "1.0";
        boolean result = compareInches(firstValue, secondValue);
        System.out.printf("Input: %s inch and %s inch%nOutput: Equal (%b)%n", firstValue, secondValue, result);
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
