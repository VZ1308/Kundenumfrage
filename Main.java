import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Eingabeaufforderung für die Anzahl der Testkundenmeinungen
        System.out.println("Bitte geben Sie an, wie viele Testkundenmeinungen simuliert werden sollen: ");

        int anzahl = 0;


        // Schleife zur sicheren Eingabe
        while (true) {
            try {
                anzahl = scanner.nextInt();

                // Überprüft, ob die Eingabe eine positive Zahl ist
                if (anzahl <= 0) {
                    System.out.println("Die Eingabe muss eine positive Zahl sein. Bitte versuchen Sie es erneut.");
                } else {
                    System.out.println("Die Eingabe war erfolgreich");
                    break; // Eingabe ist gültig, Schleife beenden
                }
            } catch (InputMismatchException e) {
                // Fängt den Fehler ab, wenn die Eingabe keine Ganzzahl ist
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.next(); // Verwerfen der fehlerhaften Eingabe
            }
        }

        // Arrays zur Speicherung der Bewertungen
        int[] bewertungen = new int[anzahl];
        String[] bewertungenText = new String[anzahl]; // speichert die Beschreibungen der Bewertungen

        // Zufällige Bewertungen für jede Testperson generieren
        for (int i = 0; i < anzahl; i++) {
            int randomInt = 1 + random.nextInt(3);
            bewertungen[i] = randomInt; // Speichert die zufällige Bewertung in das bewertungen-Array

            switch (randomInt) {
                case 1:
                    bewertungenText[i] = "nicht empfehlenswert";
                    break;
                case 2:
                    bewertungenText[i] = "akzeptabel";
                    break;
                case 3:
                    bewertungenText[i] = "hervorragend";
                    break;
                default:
                    bewertungenText[i] = "unbekannt"; // Sicherheitsmaßnahme für unerwartete Werte
                    break;
            }
        }

        // Bewertungen ausgeben
        for (int i = 0; i < anzahl; i++) {
            System.out.println("Testperson " + (i + 1) + ": " + bewertungenText[i]);
        }

        // Gesamtbewertung berechnen
        double durchschnitt = 0;
        for (int i = 0; i < anzahl; i++) {
            durchschnitt += bewertungen[i];

        }
        durchschnitt /= anzahl;

        // Gesamtbewertung ausgeben
        System.out.println("Gesamtbewertung des Produkts: " + durchschnitt);

        // Schließt das Scanner-Objekt, um Ressourcen freizugeben
        scanner.close();
    }
}
