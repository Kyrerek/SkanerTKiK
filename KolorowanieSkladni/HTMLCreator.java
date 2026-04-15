package KolorowanieSkladni;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class HTMLCreator {

    private final String fileName;
    private final StringBuilder contentBuilder = new StringBuilder();

    public HTMLCreator(String fileName) {
        this.fileName = fileName;
    }

    public void addStr(String str, Color color) {
        String html = "<span style=\"color: " + toHex(color) + ";\">" + str + "</span>";
        contentBuilder.append(html);
    }

    public void addEndl() {
        contentBuilder.append("<br>");
    }


    public void createHTML() {
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            writer.write(contentBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        contentBuilder.setLength(0); // clear
    }

    private String toHex(Color color) {
        return String.format("#%02x%02x%02x",
                color.getRed(), color.getGreen(), color.getBlue());
    }


}
