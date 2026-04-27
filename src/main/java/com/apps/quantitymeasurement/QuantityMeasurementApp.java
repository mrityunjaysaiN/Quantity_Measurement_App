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

    public static Feet parseFeet(String input) {
        Objects.requireNonNull(input, "Input must not be null");
        try {
            return new Feet(Double.parseDouble(input.trim()));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input must be a numeric feet value.", ex);
        }
    }

    public static void main(String[] args) {
        Feet first = parseFeet("1.0");
        Feet second = parseFeet("1.0");
        boolean result = first.equals(second);

        System.out.printf("Input: %.1fft and %.1fft%nOutput: Equal (%b)%n", first.getValue(), second.getValue(), result);
    }
}
