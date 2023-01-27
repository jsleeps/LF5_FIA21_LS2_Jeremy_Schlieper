
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
			 int[] liste = { 4, 2, 10, 3, -5, 0, 17 };
			 int min = 0;
			 for (int i = 0; i<liste.length;i++) {
					System.out.print(liste[i] + " ");
				}
			 
			 System.out.println();
			 
			 for (int i = 0; i<liste.length; i++) {
					for (int j = 0; j<liste.length;j++) {
						
						int tmp = liste[j];
						if(liste[j] < tmp) {
							liste[i] = tmp;
						}
					} 
				}
			 
			 for (int i = 0; i<liste.length;i++) {
					System.out.print(liste[i] + " ");
				}
	}

}
