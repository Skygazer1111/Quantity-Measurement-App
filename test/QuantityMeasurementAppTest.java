/**
 * QuantityMeasurementAppTest - Unit Tests for UC2: Feet and Inches equality
 */
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {
    
    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        boolean result = feet1.equals(feet2);

        assertTrue(result, "Two Feet objects with value 1.0 should be equal");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        boolean result = feet1.equals(feet2);

        assertFalse(result, "Two Feet objects with different values (1.0 and 2.0) should not be equal");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet = new Feet(1.0);

        boolean result = feet.equals(null);

        assertFalse(result, "A Feet object should not be equal to null");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet = new Feet(1.0);
        String nonFeetObject = "1.0";

        boolean result = feet.equals(nonFeetObject);

        assertFalse(result, "A Feet object should not be equal to a String object");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(1.0);

        boolean result = feet.equals(feet);

        assertTrue(result, "A Feet object should be equal to itself");
    }

    @Test
    public void testFeetEquality_SymmetricProperty() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);

        boolean result1 = feet1.equals(feet2);
        boolean result2 = feet2.equals(feet1);

        assertTrue(result1 && result2, "Equality should be symmetric: if feet1.equals(feet2) then feet2.equals(feet1)");
    }

    @Test
    public void testFeetEquality_TransitiveProperty() {
        Feet feet1 = new Feet(5.0);
        Feet feet2 = new Feet(5.0);
        Feet feet3 = new Feet(5.0);

        boolean result1 = feet1.equals(feet2);
        boolean result2 = feet2.equals(feet3);
        boolean result3 = feet1.equals(feet3);

        assertTrue(result1 && result2 && result3, "Equality should be transitive: if feet1.equals(feet2) and feet2.equals(feet3) then feet1.equals(feet3)");
    }

    @Test
    public void testFeetEquality_FloatingPointPrecision() {
        Feet feet1 = new Feet(1.5);
        Feet feet2 = new Feet(1.5);

        boolean result = feet1.equals(feet2);

        assertTrue(result, "Two Feet objects with floating point values (1.5 and 1.5) should be equal");
    }

    @Test
    public void testFeetEquality_NonNumericInputNaN() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Feet(Double.NaN));
        assertTrue(ex.getMessage().contains("finite numeric"), "NaN should be rejected as non-numeric input");
    }

    @Test
    public void testFeetAndInches_CrossTypeComparison() {
        Feet feet = new Feet(1.0);
        Inches inches = new Inches(1.0);

        assertFalse(feet.equals(inches), "Feet should not be equal to Inches even if values match");
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        boolean result = inch1.equals(inch2);

        assertTrue(result, "Two Inches objects with value 1.0 should be equal");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);

        boolean result = inch1.equals(inch2);

        assertFalse(result, "Two Inches objects with different values (1.0 and 2.0) should not be equal");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inch = new Inches(1.0);

        boolean result = inch.equals(null);

        assertFalse(result, "An Inches object should not be equal to null");
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inch = new Inches(1.0);
        String nonInchObject = "1.0";

        boolean result = inch.equals(nonInchObject);

        assertFalse(result, "An Inches object should not be equal to a String object");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inch = new Inches(1.0);

        boolean result = inch.equals(inch);

        assertTrue(result, "An Inches object should be equal to itself");
    }

    @Test
    public void testInchesEquality_NonNumericInputInfinity() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Inches(Double.POSITIVE_INFINITY));
        assertTrue(ex.getMessage().contains("finite numeric"), "Infinity should be rejected as non-numeric input");
    }
}
