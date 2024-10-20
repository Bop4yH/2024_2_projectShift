package ru.shift.util;

import org.apache.commons.cli.*;

import static ru.shift.Main.log;

public class OptionsHandler {
    public static final Option ARG_PATH = new Option("o", true, "results path");
    //UNUSED
    //public static final Option ARG_CONSOLE = new Option("c", false, "console mode");

    private final Options options;
    private String inputFileName;
    private String outputFileName = null;

    private boolean isValid = true;

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public boolean isValid() {
        return isValid;
    }

    public OptionsHandler(String[] args) {
        options = new Options().addOption(ARG_PATH);
        defineOptions(args);
    }

    private void defineOptions(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("o")) {
                outputFileName = cmd.getOptionValue("o");
            }

            //должно быть только имя входного файла
            String[] defaultArgs = cmd.getArgs();

            if (defaultArgs.length != 1) {
                throw new ParseException("Wrong number of arguments");
            }
            inputFileName = defaultArgs[0];

        } catch (ParseException e) {
            isValid = false;
            log.error("Не удалось обработать аргументы командной строки: {}", e.getMessage());

            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("-o out1.txt in1.txt", options);
        }
    }
}