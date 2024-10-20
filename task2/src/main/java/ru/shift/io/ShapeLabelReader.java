package ru.shift.io;

import ru.shift.util.OptionsHandler;
import ru.shift.util.ShapeLabel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static ru.shift.Main.log;

public class ShapeLabelReader {
    private final Path inputFilePath;

    public ShapeLabelReader(OptionsHandler options) {
        this.inputFilePath = Paths.get(options.getInputFileName());
    }

    public ShapeLabel readShapeLabel() throws IOException {
        try (Scanner scanner = new Scanner(Files.newInputStream(inputFilePath))) {
            String shapeType = scanner.nextLine().trim();
            String parameters = scanner.nextLine().trim();
            return new ShapeLabel(shapeType, parameters);
        } catch (NoSuchElementException e) {
            log.error("Не удалось прочитать строку из файла {}", inputFilePath);
            throw e;
        } catch (IOException e) {
            log.error("Не удалось открыть файл {}", inputFilePath);
            throw e;
        }
    }
}
