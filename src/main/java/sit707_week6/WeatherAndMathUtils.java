package sit707_week6;

public class WeatherAndMathUtils {
	public static final double DANGEROUS_WINDSPEED = 70.0;
	public static final double DANGEROUS_RAINFALL = 6.0;
	public static final double CONCERNING_WINDSPEED = 45.0;
	public static final double CONCERNING_RAINFALL = 4.0;

	/**
	 * Advises weather alert based on wind-speed and precipitation.
	 * 
	 * @param windSpeed
	 * @param precipitation
	 * @return advice: "CANCEL", "WARN", or "ALL CLEAR"
	 */
	public static String weatherAdvice(double windSpeed, double precipitation) {
		if (windSpeed < 0 || precipitation < 0) {
			throw new IllegalArgumentException("Wind speed and precipitation must be non-negative");
		}

		String advice = "ALL CLEAR";

		if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
				|| (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
			advice = "CANCEL";
		} else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
			advice = "WARN";
		}

		return advice;
	}

	/**
	 * Checks if a number is even.
	 * 
	 * @param a
	 * @return true if even, false otherwise
	 */
	public static boolean isEven(int a) {
		return a % 2 == 0;
	}

	/**
	 * Checks if a number is prime.
	 * 
	 * @param n
	 * @return true if prime, false otherwise
	 */
	public static boolean isPrime(int n) {
		if (n <= 1) return false; // Fix: 1 is not prime

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
