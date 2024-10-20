package ru.shift.io;

import ru.shift.util.OptionsHandler;
import ru.shift.info.FigureInfo;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ru.shift.Main.log;

public class FigureInfoWriter {
    public static void writeFormattedInfo(OptionsHandler options, FigureInfo figureInfo) {
        try (PrintWriter writer = initializeWriter(options.getOutputFileName())){
            writer.println(figureInfo.getFormattedInfo());
        } catch (IOException e) {
            log.error("Не удалось записать выходные данные");
        }
    }

    private static PrintWriter initializeWriter(String outputFileName) throws IOException {
        if (outputFileName != null) {
            try {
                return initializeFileWriter(outputFileName);
            }
            catch (FileNotFoundException e){
                log.error("Не удалось записать выходные данные в файл {}", outputFileName);
                log.warn("Выходные данные будут записаны в консоль");
            }
        }

        return initializeConsoleWriter();
    }

    private static PrintWriter initializeConsoleWriter(){
        return new PrintWriter(System.out);
    }

    private static PrintWriter initializeFileWriter(String outputFileName) throws FileNotFoundException {
        Path filePath = Paths.get(outputFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(fileOutputStream)));
    }
}
