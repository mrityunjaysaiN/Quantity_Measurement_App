package com.apps.quantitymeasurement;

public class Length {

    public enum LengthUnit {
        FEET(12.0, "feet", "foot"),
        INCHES(1.0, "inches", "inch");

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

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Length unit must not be null.");
        }
        this.value = value;
        this.unit = unit;
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
        return Double.compare(convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
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
        return Double.hashCode(convertToBaseUnit());
    }
}
