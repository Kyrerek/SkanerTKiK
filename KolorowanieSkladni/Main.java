package KolorowanieSkladni;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Skaner skaner = new Skaner();
        File entry = new File("kod.txt");
        HTMLCreator htmlCreator = new HTMLCreator("kod.html");
        try (Scanner myReader = new Scanner(entry)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] data = line.split("(?<=\\s)|(?=\\s)",-1);
                for (String dataPart: data){
                    if (dataPart.isEmpty()){
                        continue;
                    }
                    if (Character.isWhitespace(dataPart.charAt(0))){
                        htmlCreator.addWhiteChars(dataPart);
                    }else{
                        skaner.init(dataPart);
                        while (skaner.hasNext()) {
                            Token t = skaner.skaner();
                            htmlCreator.addColorStr(t.wartosc(),t.kod().color);
                            System.out.println(t.kod() + ": " + t.wartosc());
                        }
                    }
                }
                htmlCreator.addEndl();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        htmlCreator.createHTML(48);
    }
}
