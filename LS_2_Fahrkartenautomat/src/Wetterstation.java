public class Wetterstation {

	public static double wetter_durchschnitt(double[] wetterdaten) {
		double durchschnitt = 0.0;
		for (int i = 0; i < wetterdaten.length; i++) {
			durchschnitt = durchschnitt + wetterdaten[i];
		}
		return durchschnitt = durchschnitt / wetterdaten.length;
	}

	public static double wetter_minimum(double[] wetterdaten) {
		double minimum = 0.0;
		for (int i = 0; i < wetterdaten.length; i++) {
			if (minimum > wetterdaten[i]) {
				minimum = wetterdaten[i];
			}
		}
		
		return minimum;
	}
	
	public static double wetter_maximum(double[] wetterdaten) {
		double maximum = 0.0;
		for (int i = 0; i < wetterdaten.length; i++) {
			if (maximum < wetterdaten[i]) {
				maximum = wetterdaten[i];
			}
		}
		
		return maximum;
	}
	
	public static double wetter_umschwung(double[] wetterdaten) {
		double umschwung = 0.0;
		double biggest = 0.0;
		for (int i = 1; i < wetterdaten.length; i++) {
			boolean minus = false;
			double x = wetterdaten[i-1] - wetterdaten[i];
			if (x < 0) {
				x = x * -1;
				minus = true;
			}
			if (biggest < x) {
				if (minus) {
					x = x * -1;
				}
				umschwung = x;
			}
		}
		return umschwung;
	}
	
	public static void main(String[] args) {
		double[] wetterdaten = { -15.55, -2.55, -11.44, -8.6, -14.4, -5.17, 1.48, -3.47, 2.00, 2.14, 4.05, 7.45, 3.25,
				5.04, 11.4, 7.67, 8.64, 13.28, 6.87, 15.54, 12.45, 16.55, 20.42, 22.38, 19.58, 18.85, 23.84, 24.42,
				25.54, 28.35, 30.16, 32.44, 26.55, 22.13, 16.64, 13.33, 16.45, 17.34, 15.33, 11.13, 15.16, 11.44, 6.55,
				2.13, 6.64, 3.33, 6.45, -1.34, 5.33, -11.15 };
		System.out.printf("Durchschnitt: %,.2f°%n", wetter_durchschnitt(wetterdaten));
		System.out.printf("Minimum: %,.2f°%n", wetter_minimum(wetterdaten));
		System.out.printf("Maximum: %,.2f°%n", wetter_maximum(wetterdaten));
		System.out.printf("Umschwung: %,.2f°%n", wetter_umschwung(wetterdaten));
		
	}
}
