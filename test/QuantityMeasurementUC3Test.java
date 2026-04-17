package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementUC3Test {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length1.equals(length2), "Quantity(1.0, FEET) should equal Quantity(1.0, FEET)");
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2), "Quantity(1.0, INCHES) should equal Quantity(1.0, INCHES)");
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches), "Quantity(1.0, FEET) should equal Quantity(12.0, INCHES)");
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(inches.equals(feet), "Quantity(12.0, INCHES) should equal Quantity(1.0, FEET)");
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2), "Quantity(1.0, FEET) should not equal Quantity(2.0, FEET)");
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);

        assertFalse(length1.equals(length2), "Quantity(1.0, INCHES) should not equal Quantity(2.0, INCHES)");
    }

    @Test
    void testEquality_NullUnit() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
        assertTrue(ex.getMessage().contains("must not be null"), "Null unit should be rejected");
    }

    @Test
    void testEquality_SameReference() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length.equals(length), "Object should equal itself");
    }

    @Test
    void testEquality_NullComparison() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length.equals(null), "Length should not be equal to null");
    }

    @Test
    void testEquality_NonLengthTypeComparison() {
        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length.equals("1.0 FEET"), "Length should not be equal to non-Length type");
    }

    @Test
    void testEquality_InvalidNumericValue_NaN() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Length(Double.NaN, Length.LengthUnit.FEET));
        assertTrue(ex.getMessage().contains("finite numeric"), "NaN should be rejected");
    }

    @Test
    void testEquality_InvalidNumericValue_Infinite() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Length(Double.POSITIVE_INFINITY, Length.LengthUnit.INCHES));
        assertTrue(ex.getMessage().contains("finite numeric"), "Infinity should be rejected");
    }

    @Test
    void testEquality_TransitiveProperty() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        Length c = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(a.equals(b) && b.equals(c) && a.equals(c), "equals must satisfy transitive property");
    }

    @Test
    void testEquality_ConsistentProperty() {
        Length left = new Length(24.0, Length.LengthUnit.INCHES);
        Length right = new Length(2.0, Length.LengthUnit.FEET);

        boolean first = left.equals(right);
        boolean second = left.equals(right);

        assertTrue(first && second, "equals must be consistent across repeated calls");
    }

    @Test
    void testLegacyCompatibility_FeetWrapper() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "Legacy Feet wrapper should still work");
    }

    @Test
    void testLegacyCompatibility_InchesWrapper() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inch1.equals(inch2), "Legacy Inches wrapper should still work");
    }
}
