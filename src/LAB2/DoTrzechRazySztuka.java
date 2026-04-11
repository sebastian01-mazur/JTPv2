/*Zaimplementuj klasę DoTrzechRazySztuka, która sczytuje z konsoli liczbę float i wypisuje ją w postaci
 np. „x = 1.2” (zobacz slajdy z pierwszego wykładu). Metoda ta powinna dopuszczać maksymalnie dwa błędy
 w typie danych, np. jeśli podczas pierwszej próby wpisany będzie string „abc”, to jest to błąd i metoda powinna
 zażądać innej danej i tak maksymalnie dwa razy. Metoda ma kończyć swoje wykonanie po pierwszym wprowadzeniu float przy
  maksymalnie trzech próbach.*/
package LAB2;
import java.util.Scanner;

public class DoTrzechRazySztuka {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 3;
        int currentAttempt = 0;

        System.out.println("Wprowadź liczbę zmiennoprzecinkową (masz 3 próby).");

        while (currentAttempt < maxAttempts) {
            System.out.print("Próba " + (currentAttempt + 1) + ": ");
            String input = scanner.nextLine(); // Sczytujemy wszystko jako tekst

            try {
                float value = Float.parseFloat(input);
                System.out.println("x = " + value);
                break; // Kończy pętlę i program po pierwszym poprawnym wprowadzeniu

            } catch (NumberFormatException e) {
                // Jeśli wpisano np. "abc", parser rzuci błąd
                currentAttempt++;

                if (currentAttempt < maxAttempts) {
                    System.out.println("Błąd w typie danych! To nie jest liczba float. Spróbuj ponownie.");
                } else {
                    System.out.println("Przekroczono limit błędów. Zamykanie programu.");
                }
            }
        }

        scanner.close();
    }
}