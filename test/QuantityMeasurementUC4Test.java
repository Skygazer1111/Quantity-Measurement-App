package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementUC4Test {

    @Test
    void testEquality_YardToYard_SameValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(yard1.equals(yard2), "Quantity(1.0, YARDS) should equal Quantity(1.0, YARDS)");
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length yard2 = new Length(2.0, Length.LengthUnit.YARDS);

        assertFalse(yard1.equals(yard2), "Quantity(1.0, YARDS) should not equal Quantity(2.0, YARDS)");
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(yards.equals(feet), "Quantity(1.0, YARDS) should equal Quantity(3.0, FEET)");
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(feet.equals(yards), "Quantity(3.0, FEET) should equal Quantity(1.0, YARDS)");
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yards.equals(inches), "Quantity(1.0, YARDS) should equal Quantity(36.0, INCHES)");
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(inches.equals(yards), "Quantity(36.0, INCHES) should equal Quantity(1.0, YARDS)");
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(yards.equals(feet), "Quantity(1.0, YARDS) should not equal Quantity(2.0, FEET)");
    }

    @Test
    void testEquality_CentimetersToCentimeters_SameValue() {
        Length cm1 = new Length(2.0, Length.LengthUnit.CENTIMETERS);
        Length cm2 = new Length(2.0, Length.LengthUnit.CENTIMETERS);

        assertTrue(cm1.equals(cm2), "Quantity(2.0, CENTIMETERS) should equal Quantity(2.0, CENTIMETERS)");
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        Length centimeters = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(centimeters.equals(inches), "Quantity(1.0, CENTIMETERS) should equal Quantity(0.393701, INCHES)");
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Length centimeters = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(centimeters.equals(feet), "Quantity(1.0, CENTIMETERS) should not equal Quantity(1.0, FEET)");
    }

    @Test
    void testEquality_CentimetersToYards_EquivalentValue() {
        Length centimeters = new Length(91.44, Length.LengthUnit.CENTIMETERS);
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(centimeters.equals(yards), "Quantity(91.44, CENTIMETERS) should equal Quantity(1.0, YARDS)");
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yards.equals(feet), "Yards should equal feet conversion");
        assertTrue(feet.equals(inches), "Feet should equal inches conversion");
        assertTrue(yards.equals(inches), "Transitive property should hold across units");
    }

    @Test
    void testEquality_YardWithNullUnit() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
        assertTrue(ex.getMessage().contains("must not be null"), "Null unit should be rejected");
    }

    @Test
    void testEquality_SameReference_AllUnits() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length centimeter = new Length(10.0, Length.LengthUnit.CENTIMETERS);

        assertTrue(yard.equals(yard), "Yard length should equal itself");
        assertTrue(centimeter.equals(centimeter), "Centimeter length should equal itself");
    }

    @Test
    void testEquality_NullComparison_AllUnits() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length centimeter = new Length(10.0, Length.LengthUnit.CENTIMETERS);

        assertFalse(yard.equals(null), "Yard length should not equal null");
        assertFalse(centimeter.equals(null), "Centimeter length should not equal null");
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        Length yards = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);
        Length centimeters = new Length(182.88, Length.LengthUnit.CENTIMETERS);

        assertTrue(yards.equals(feet), "2 yards should equal 6 feet");
        assertTrue(feet.equals(inches), "6 feet should equal 72 inches");
        assertTrue(inches.equals(centimeters), "72 inches should equal 182.88 centimeters");
        assertTrue(yards.equals(centimeters), "2 yards should equal 182.88 centimeters");
    }

    @Test
    void testLegacyCompatibility_YardsWrapper() {
        QuantityMeasurementApp.Yards yard1 = new QuantityMeasurementApp.Yards(1.0);
        QuantityMeasurementApp.Yards yard2 = new QuantityMeasurementApp.Yards(1.0);

        assertTrue(yard1.equals(yard2), "Legacy-style Yards wrapper should work");
    }

    @Test
    void testLegacyCompatibility_CentimetersWrapper() {
        QuantityMeasurementApp.Centimeters cm1 = new QuantityMeasurementApp.Centimeters(1.0);
        QuantityMeasurementApp.Centimeters cm2 = new QuantityMeasurementApp.Centimeters(1.0);

        assertTrue(cm1.equals(cm2), "Legacy-style Centimeters wrapper should work");
    }
}
