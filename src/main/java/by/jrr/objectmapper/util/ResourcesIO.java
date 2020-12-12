package by.jrr.objectmapper.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static by.jrr.ObjectMapperApplication.RESOURCES;

public class ResourcesIO {

    public static void writeStringToPath(String fileName, String text) {
        Path file = Paths.get(RESOURCES.concat(fileName));
        try(Writer writer = new BufferedWriter(Files.newBufferedWriter(file, Charset.forName("utf-8")))) {
            writer.write(text);
        } catch (Exception ex) {

        }
    }

    public static String readStringFromPath(String fileName) {
        Path file = Paths.get(RESOURCES.concat(fileName));
        try(BufferedReader reader = new BufferedReader(Files.newBufferedReader(file))) {
            return reader.lines()
            .collect(Collectors.joining("\n"));
        } catch (Exception ex) {

        }
        return "";
    }
}
