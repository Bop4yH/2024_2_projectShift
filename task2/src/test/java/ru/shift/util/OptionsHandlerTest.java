package ru.shift.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionsHandlerTest {
    final String[] args = {"in.txt", "-o", "out.txt"};
    final OptionsHandler optionsHandler = new OptionsHandler(args);

    @Test
    void getInputFileName() {
        String exp = args[0];
        String act = optionsHandler.getInputFileName();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getOutputFileName() {
        String exp = args[2];
        String act = optionsHandler.getOutputFileName();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void isValid() {
        boolean exp = true;
        boolean act = optionsHandler.isValid();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void isValidWhenNoArgumentsThenFalse() {
        String[] args = {"-o", "out.txt"};
        OptionsHandler optionsHandler = new OptionsHandler(args);

        boolean exp = false;
        boolean act = optionsHandler.isValid();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void isValidWhenMoreThanOneArgumentThenFalse() {
        String[] args = {"-o", "out.txt", "in1.txt", "in2.txt"};
        OptionsHandler optionsHandler = new OptionsHandler(args);

        boolean exp = false;
        boolean act = optionsHandler.isValid();
        assertThat(act).isEqualTo(exp);
    }
}