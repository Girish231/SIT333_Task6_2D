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
    public void testCrossCheckIsEvenWithManualCheck() {
        int number = 10;
        boolean expected = (number % 2 == 0);
        boolean actual = WeatherAndMathUtils.isEven(number);

        Assert.assertEquals(expected, actual);
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
    public void testNegativeWindSpeedThrowsException() {
        WeatherAndMathUtils.weatherAdvice(-10.0, 3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRainfallThrowsException() {
        WeatherAndMathUtils.weatherAdvice(40.0, -1.0);
    }

    // === Performance (P) ===
    @Test(timeout = 100)
    public void testPerformanceIsPrimeLargeNumber() {
        WeatherAndMathUtils.isPrime(999983); // Known large prime number
    }

    @Test(timeout = 50)
    public void testPerformanceWeatherAdviceLoop() {
        for (int i = 0; i < 1000; i++) {
            WeatherAndMathUtils.weatherAdvice(30.0 + i % 10, 2.0 + i % 5);
        }
    }
}
