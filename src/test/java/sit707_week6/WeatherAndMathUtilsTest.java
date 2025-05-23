package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    // === Student Info Tests ===
    @Test
    public void testStudentIdentity() {
        String studentId = "222121587";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Girish Sirpali";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // === Right Result (R) ===
    @Test
    public void testIsEvenTrue() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testIsEvenFalse() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    @Test
    public void testIsPrimeTrue() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
    }

    @Test
    public void testIsPrimeFalse() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
    }

    // === Boundary Conditions (B) ===
    @Test
    public void testBoundaryWindExactlyDangerous() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(70.0, 0.0));
    }

    @Test
    public void testBoundaryRainExactlyConcerning() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 4.0));
    }

    // === Inverse Relationship (I) ===
    @Test
    public void testInverseRelationshipEvenOdd() {
        int original = 4;
        boolean isEvenOriginal = WeatherAndMathUtils.isEven(original);
        boolean isEvenPlusOne = WeatherAndMathUtils.isEven(original + 1);
        Assert.assertNotEquals(isEvenOriginal, isEvenPlusOne);
    }

    @Test
    public void testInverseRelationshipPrimeComposite() {
        int prime = 7;
        int multiple = prime * 2;
        Assert.assertFalse(WeatherAndMathUtils.isPrime(multiple));
    }

    // === Cross-check (C) ===
    @Test
    public void testCrossCheckIsEvenWithRange() {
        for (int i = -10; i <= 10; i++) {
            boolean expected = (i % 2 == 0);
            boolean actual = WeatherAndMathUtils.isEven(i);
            Assert.assertEquals("Failed at number: " + i, expected, actual);
        }
    }

    @Test
    public void testCrossCheckWeatherAdviceLogic() {
        double wind = 80.0;
        double rain = 0.0;
        String advice = WeatherAndMathUtils.weatherAdvice(wind, rain);
        Assert.assertEquals("CANCEL", advice);
    }

    // === Error Conditions (E) ===
    @Test(expected = IllegalArgumentException.class)
    public void testIsEvenWithInvalidInput() {
        WeatherAndMathUtils.isEven(Integer.MIN_VALUE - 1); // Example overflow, adjust if not supported
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrimeWithInvalidInput() {
        WeatherAndMathUtils.isPrime(-10);
    }   

    // === Boundary Test: Zero wind speed and rainfall ===
    @Test
    public void testZeroWindSpeedAndRainfall() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }

    // === Performance (P) ===
    @Test(timeout = 100)
    public void testPerformanceIsPrimeLargeNumber() {
        WeatherAndMathUtils.isPrime(999983);
    }

    @Test(timeout = 50)
    public void testPerformanceWeatherAdviceLoop() {
        for (int i = 0; i < 1000; i++) {
            WeatherAndMathUtils.weatherAdvice(30.0 + i % 10, 2.0 + i % 5);
        }
    }

    // === Additional WeatherAdvice boundary and branch tests ===
    @Test
    public void testWindSpeedJustAboveDangerous() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testWindSpeedJustBelowDangerous() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(69.9, 0.0));
    }

    @Test
    public void testRainfallJustAboveDangerous() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testRainfallJustBelowDangerous() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 5.9));
    }

    @Test
    public void testWindSpeedJustAboveConcerningRainfallBelow() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 3.9));
    }

    @Test
    public void testWindSpeedBelowConcerningRainfallJustAbove() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(44.9, 4.1));
    }

    @Test
    public void testWindSpeedAndRainfallBothAboveConcerningBelowDangerous() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 5.0));
    }

    // === Additional isPrime tests for edge cases ===
    @Test
    public void testIsPrimeWithZeroOneAndNegative() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-3));
    }

    // === isEven tests with negative numbers ===
    @Test
    public void testIsEvenWithNegativeNumbers() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-4));
        Assert.assertFalse(WeatherAndMathUtils.isEven(-5));
    }

    // === Additional Test Cases Added Below ===

    // Test very large even number
    @Test
    public void testIsEvenWithLargeEvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(Integer.MAX_VALUE - 1));
    }

    // Test very large odd number
    @Test
    public void testIsEvenWithLargeOddNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(Integer.MAX_VALUE));
    }

    // Test isPrime with a large known composite number
    @Test
    public void testIsPrimeWithLargeComposite() {
        // 999983 * 2 = 1999966 (even and composite)
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1999966));
    }

    // Test weatherAdvice with high wind and rain to confirm CANCEL
    @Test
    public void testWeatherAdviceHighWindAndRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(100.0, 10.0));
    }

    // Test weatherAdvice with borderline values exactly at concerning thresholds
    @Test
    public void testWeatherAdviceAtConcerningThresholds() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.0, 5.0));
    }

    // Test weatherAdvice with borderline values just above cancel threshold for wind or rain
    @Test
    public void testWeatherAdviceJustAboveCancelThresholdWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.01, 5.0));
    }

    @Test
    public void testWeatherAdviceJustAboveCancelThresholdRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.0, 6.01));
    }

    // Test isPrime with prime number 2 (smallest prime)
    @Test
    public void testIsPrimeWithSmallestPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    // Test isEven with zero (edge case)
    @Test
    public void testIsEvenWithZero() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }
}
