import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Skaner skaner = new Skaner();
        Scanner input = new Scanner(System.in);

        System.out.print("Podaj wyrażenie: ");
        String wyrazenie = input.nextLine();

        for (char token : wyrazenie.toCharArray()) {
            skaner.skaner(token);
        }
        System.out.println("EOF");
    }
}