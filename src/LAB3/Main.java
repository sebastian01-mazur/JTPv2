package LAB3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- TESTY (od -4 do 5) ---");

        // Używamy pętli for, aby przejść przez liczby od -4 do 5 włącznie
        for (int i = -4; i <= 5; i++) {
            System.out.print("Test (Liczba " + i + "): ");

            try {
                //liczenie
                long result = Factorial.factorial(i);
                System.out.println("Wynik = " + result);
            } catch (IllegalArgumentException e) {
                // DLA UJEMNEJ BŁAD
                System.out.println("Odrzucono! Powód: " + e.getMessage());
            }
        }

        System.out.println("--- Koniec testów ---\n"); // \n  pusta linijka

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę całkowitą: ");

        int userNumber = scanner.nextInt();

        try {
            long result = Factorial.factorial(userNumber);
            System.out.println("Silnia z " + userNumber + " wynosi: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        scanner.close();
    }
}