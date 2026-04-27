package com.apps.quantitymeasurement;

/**
 * A generic class for representing and comparing lengths in different units.
 *
 * <p>Conversion and comparison are normalized through a common base unit of
 * inches, defined by the {@link LengthUnit} enum. This class provides both
 * equality semantics and unit conversion APIs for supported length units.</p>
 */
public class Length {

    public enum LengthUnit {
        FEET(12.0, "feet", "foot", "ft"),
        INCHES(1.0, "inches", "inch", "in"),
        YARDS(36.0, "yards", "yard", "yd"),
        CENTIMETERS(0.393701, "centimeters", "centimeter", "cm");

        private final double conversionFactor;
        private final String[] aliases;

        LengthUnit(double conversionFactor, String... aliases) {
            this.conversionFactor = conversionFactor;
            this.aliases = aliases;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }

        public static LengthUnit from(String unitName) {
            if (unitName == null) {
                throw new IllegalArgumentException("Unit name must not be null.");
            }
            for (LengthUnit unit : values()) {
                for (String alias : unit.aliases) {
                    if (alias.equalsIgnoreCase(unitName.trim())) {
                        return unit;
                    }
                }
            }
            throw new IllegalArgumentException("Unsupported length unit: " + unitName);
        }
    }

    private static final double EPSILON = 1e-6;

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Length unit must not be null.");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Length value must be a finite number.");
        }
        this.value = value;
        this.unit = unit;
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Length value must be a finite number.");
        }
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Length units must not be null.");
        }
        double baseValue = value * sourceUnit.getConversionFactor();
        return baseValue / targetUnit.getConversionFactor();
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit must not be null.");
        }
        return new Length(convert(value, unit, targetUnit), targetUnit);
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Compared length must not be null.");
        }
        return Math.abs(convertToBaseUnit() - thatLength.convertToBaseUnit()) < EPSILON;
    }

    @Override
    public String toString() {
        return String.format("%.6f %s", value, unit.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Length that = (Length) o;
        return compare(that);
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(convertToBaseUnit() / EPSILON);
        return Long.hashCode(rounded);
    }
}
