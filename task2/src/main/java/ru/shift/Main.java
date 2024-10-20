package ru.shift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shift.io.FigureInfoWriter;
import ru.shift.io.ShapeLabelReader;
import ru.shift.util.LabelParser;
import ru.shift.util.OptionsHandler;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Начало программы");

        var options = new OptionsHandler(args);
        if (!options.isValid()) {
            System.exit(0);
        }

        var reader = new ShapeLabelReader(options);
        var figureInfo = LabelParser.parseToInfo(reader);

        if (figureInfo == null) {
            System.exit(0);
        }

        FigureInfoWriter.writeFormattedInfo(options, figureInfo);
        log.info("Программа успешно завершилась");
    }


}