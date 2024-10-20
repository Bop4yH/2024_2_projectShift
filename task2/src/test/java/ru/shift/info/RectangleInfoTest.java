package ru.shift.info;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleInfoTest {

    @Test
    void getFormattedInfo() {
        RectangleInfo rectangleInfo = new RectangleInfo(20, 24, 10, 2, 10.2);
        String exp = """
                Тип фигуры: RECTANGLE
                Площадь: 20 кв. см
                Периметр: 24 см
                Длина диагонали: 10,2 см
                Длина: 10 см
                Ширина: 2 см
                """;
        String act = rectangleInfo.getFormattedInfo();
        assertThat(act).isEqualTo(exp);
    }
}