import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag = 0.0; // verändert
		double eingezahlterGesamtbetrag;

		begruessung();
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgabe();
		rueckgeldAusgabe(zuZahlenderBetrag, eingezahlterGesamtbetrag);

		tastatur.close();
	}

	// Kartenauswahl
	public static void begruessung() {
		System.out.println("Herzlich Willkomnen !\r\n" + "Wählen Sie eine Fahrkarte aus:");

	}

	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		double ticketPreis = 0;
		int anzahlTickets = 0;
		double zuZahlenderBetrag = 0.0;
		String[] fahrkartenBezeichnung = new String[] { "Einzelfahrschein AB", "Einzelfahrschein BC",
				"Einzelfahrschein ABC", "Kurzstrecke AB", "Tageskarte AB", "Tageskarte BC", "Tageskarte ABC",
				"4-Fahrten-Karte AB", "4-Fahrten-Karte BC", "4-Fahrten-Karte ABC", "Kleingruppen-Tageskarte AB",
				"Kleingruppen-Tageskarte BC", "Kleingruppen-Tageskarte ABC" };
		double[] fahrkartenPreis = new double[] { 3.00D, 3.50D, 3.80D, 2.00D, 8.60D, 9.20D, 10.00D, 9.40D, 12.60D,
				13.80D, 25.50D, 26.00D, 26.50D };
		boolean korrekteEingabe;
		int auswahlTickets;

		boolean auswahlBeenden = false; // neu

		while (true) { // neu

			korrekteEingabe = false; // neu
			auswahlTickets = 0; // neu

			while (korrekteEingabe == false) {
				for (int i = 0; i < fahrkartenBezeichnung.length; i++) {
					System.out.printf("%2d -> %s %.2f%n", i + 1, fahrkartenBezeichnung[i], fahrkartenPreis[i]);
				}
				System.out.println("14 -> Beenden");
				System.out.print("Ihre Wahl: ");
				auswahlTickets = tastatur.nextInt();
				if (auswahlTickets >= 1 && auswahlTickets <= 13) {
					korrekteEingabe = true;
				} else if (auswahlTickets == 14) { // neu
					korrekteEingabe = true; // neu
					auswahlBeenden = true; // neu
				} // neu
				else {
					System.out.println(" >>falsche Eingabe<< ");
				}
			}

			if (auswahlBeenden) { // neu
				break; // neu
			}

			ticketPreis = fahrkartenPreis[auswahlTickets-1];
			
			// Ticketanzahl
			korrekteEingabe = false;

			while (korrekteEingabe == false) {
				System.out.print("Anzahl der Tickets: ");
				anzahlTickets = tastatur.nextInt();

				if (anzahlTickets >= 1 && anzahlTickets <= 10)
					korrekteEingabe = true;
				else
					System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<\n");

			}

			zuZahlenderBetrag = zuZahlenderBetrag + ticketPreis * anzahlTickets; // verändert

			System.out.format("%nZwischensumme: %4.2f € %n%n", zuZahlenderBetrag); // neu

		}
		return zuZahlenderBetrag;
	}

	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double nochZuZahlen;

		// Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %4.2f Euro\n", nochZuZahlen);

			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
	}

	public static void fahrkartenAusgabe() {
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}

	public static void rueckgeldAusgabe(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		double rueckgabebetrag;

		// Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.format("Der Rückgabebetrag in Höhe von %4.2f Euro \n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = Math.round(rueckgabebetrag * 100.0) / 100.0;
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

	}
}
