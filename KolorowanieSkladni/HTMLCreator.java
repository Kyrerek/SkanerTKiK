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

    public void addColorStr(String str, Color color) {
        String html = "<span style=\"color: " + toHex(color) + ";\">" + str + "</span>";
        contentBuilder.append(html);
    }

    public void addEndl() {
        contentBuilder.append("<br>");
    }

    public void addWhiteChars(String str) {
        String html = "<span style=\"white-space: pre;\">" + str + "</span>";
        contentBuilder.append(html);
    }


    public void createHTML(int fontSize) {
        String html = "<span style=\"font-size: " + fontSize + "px;\">" + contentBuilder.toString() + "</span>";
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            writer.write(html);
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
