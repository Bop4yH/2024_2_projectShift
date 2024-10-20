package ru.shift.info;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircleInfoTest {


    @Test
    void getFormattedInfo() {
        CircleInfo circleInfo = new CircleInfo(452.39, 75.4, 12, 24);
        String exp = """
                Тип фигуры: CIRCLE
                Площадь: 452,39 кв. см
                Периметр: 75,4 см
                Радиус: 12 см
                Диаметр: 24 см
                """;
        String act = circleInfo.getFormattedInfo();
        assertThat(act).isEqualTo(exp);
    }
}