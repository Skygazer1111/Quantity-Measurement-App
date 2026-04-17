/**
 * Generic Length quantity used for all supported units.
 */
package com.apps.quantitymeasurement;

public class Length {
    private static final double EQUALITY_TOLERANCE = 1e-9;

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        validateFinite(value);
        if (unit == null) {
            throw new IllegalArgumentException("Length unit must not be null");
        }
        this.unit = unit;
        this.value = value;
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

    private static void validateFinite(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Length value must be a finite numeric value");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Length)) {
            return false;
        }

        Length other = (Length) obj;
        double leftInInches = this.convertToBaseUnit();
        double rightInInches = other.convertToBaseUnit();
        return Math.abs(leftInInches - rightInInches) <= EQUALITY_TOLERANCE;
    }

    @Override
    public int hashCode() {
        long normalizedValue = Math.round(convertToBaseUnit() / EQUALITY_TOLERANCE);
        return Long.hashCode(normalizedValue);
    }
}
