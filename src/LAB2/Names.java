package LAB2;
//packag
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Names {
    // Obiektowy atrybut odpowiadający liście klientów
    private List<String> names;
    // Obiekt do generowania liczb losowych
    private Random random;

    // Konstruktor klasy - inicjalizuje listę i generator
    public Names(List<String> initialNames) {
        // Tworzymy nową listę na podstawie przekazanej,
        // aby nie modyfikować oryginalnej kolekcji z zewnątrz
        this.names = new ArrayList<>(initialNames);
        this.random = new Random();
    }

    // Obiektowa metoda choose() - losuje, zwraca i usuwa
    public String choose() {
        // Zabezpieczenie przed losowaniem z pustej listy
        if (names.isEmpty()) {
            System.out.println("Lista klientów jest pusta!");
            return null;
        }

        // 1. Losujemy indeks (od 0 do rozmiaru listy minus 1)
        int randomIndex = random.nextInt(names.size());

        // 2. Metoda remove() usuwa element pod danym indeksem
        // i jednocześnie zwraca jego wartość.
        return names.remove(randomIndex);
    }

    // Dodatkowa metoda do sprawdzenia, czy są jeszcze jacyś klienci
    public boolean hasMoreNames() {
        return !names.isEmpty();
    }

    // --- METODA MAIN DO PRZETESTOWANIA KODU ---
    public static void main(String[] args) {
        // Przygotowanie początkowej listy klientów
        List<String> klienci = new ArrayList<>();
        klienci.add("Jan Kowalski");
        klienci.add("Anna Nowak");
        klienci.add("Piotr Wiśniewski");
        klienci.add("Katarzyna Wójcik");

        // Utworzenie obiektu klasy Names
        Names losowanie = new Names(klienci);

        System.out.println("Rozpoczynamy losowanie nagród!");
        System.out.println("------------------------------");

        // Losujemy dopóki lista nie będzie pusta
        while (losowanie.hasMoreNames()) {
            String wylosowanyKlient = losowanie.choose();
            System.out.println("Wylosowano: " + wylosowanyKlient);
        }

        System.out.println("------------------------------");
        System.out.println("Koniec losowania, lista jest pusta.");
    }
}