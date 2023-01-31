import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 Das Sortierverfahren Selection-Sort arbeitet nachfolgendem Prinzip:
//
//			 1.   Der Index des kleinsten Wertes wird bestimmt.
//
//			 2.   Dieses kleinste Element wird mit dem ersten Element vertauscht (d.h. das erste Element ist nun bereits das kleinste).
//
//			 3.   Danach wird, beginnend mit dem 2. Element, wiederum das Minimum bestimmt und dieses Element mit dem 2. vertauscht (jetzt sind bereits zwei Elemente in der richtigen Reihenfolge)
//
//			 4.   Die Minimum-Suche und das Vertauschen werden so lange wiederholt, bis das vorletzte Element erreicht wurde (dieses kann dann ggf. mit dem letzten Element vertauscht werden)
//
//			 5.   Danach ist das Array vollständig sortiert.
//
//			  Programmieren Sie das Verfahren Selection-Sort so, dass das Array aufsteigend sortiert wird.
//
//			  Beispiel:
//
		int[] numbers = { 5, 2, 9, 1, 3, 12, 123, 123, 345, 654, 7657, 86, 4, 5, 79, 0 };
		int n = numbers.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = temp;
		}
		System.out.println(Arrays.toString(numbers));

	}
}
