import java.util.Scanner;

class Main {
    void main() {
        Skaner skaner = new Skaner();
        Scanner input = new Scanner(System.in);

        System.out.print("Podaj wyrażenie: ");
        String wyrazenie = input.nextLine().replaceAll("\\s+", "");
        int i = 0;

        while( i < wyrazenie.length()) {
            i = skaner.skaner(wyrazenie, i);
        }
        System.out.println("EOF");
    }
}