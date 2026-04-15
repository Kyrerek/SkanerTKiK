package KolorowanieSkladni;

import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Skaner skaner = new Skaner();
        File entry = new File("kod.txt");
        try (Scanner myReader = new Scanner(entry)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().replaceAll("\\s+", "");
                skaner.init(data);
                while (skaner.hasNext()) {
                    Token t = skaner.skaner();
                    System.out.println(t.kod() + ": " + t.wartosc());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        HTMLCreator htmlCreator = new HTMLCreator("example.html");
        htmlCreator.addStr("Witaj!", Color.RED);
        htmlCreator.addStr("  !!!", Color.GREEN);
        htmlCreator.addEndl();
        htmlCreator.addStr("Koniec!", Color.BLUE);
        htmlCreator.createHTML();
    }
}
