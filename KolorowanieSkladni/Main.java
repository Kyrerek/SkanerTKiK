package KolorowanieSkladni;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        HTMLCreator htmlCreator = new HTMLCreator("example.html");
        htmlCreator.addStr("Witaj!", Color.RED);
        htmlCreator.addStr("  !!!", Color.GREEN);
        htmlCreator.addEndl();
        htmlCreator.addStr("Koniec!", Color.BLUE);
        htmlCreator.createHTML();
    }
}
