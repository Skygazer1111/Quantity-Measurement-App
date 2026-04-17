/**
 * QuantityMeasurementApp - UC4: Extended Unit Support.
 */
package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

    /**
     * Backward-compatible wrapper for UC1 tests and usage.
     */
    public static class Feet extends Length {
        public Feet(double value) {
            super(value, Length.LengthUnit.FEET);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    /**
     * Backward-compatible wrapper for UC2 tests and usage.
     */
    public static class Inches extends Length {
        public Inches(double value) {
            super(value, Length.LengthUnit.INCHES);
        }
    }

    public static class Yards extends Length {
        public Yards(double value) {
            super(value, Length.LengthUnit.YARDS);
        }
    }

    public static class Centimeters extends Length {
        public Centimeters(double value) {
            super(value, Length.LengthUnit.CENTIMETERS);
        }
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        System.out.println("Input: Quantity(1.0, FEET) and Quantity(1.0, FEET)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static void demonstrateInchesEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, INCHES) and Quantity(1.0, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, FEET) and Quantity(12.0, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static void demonstrateYardsInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, YARDS) and Quantity(36.0, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static void demonstrateCentimetersInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHES);
        System.out.println("Input: Quantity(1.0, CENTIMETERS) and Quantity(0.393701, INCHES)");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
        demonstrateYardsInchesComparison();
        demonstrateCentimetersInchesComparison();
    }

    public static void demonstrateInchesEquality() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: " + (inch1.equals(inch2) ? "Equal (true)" : "Not Equal (false)"));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
