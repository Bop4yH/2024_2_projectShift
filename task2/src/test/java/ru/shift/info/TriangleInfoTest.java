package ru.shift.info;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleInfoTest {

    @Test
    void getFormattedInfo() {
        TriangleInfo triangleInfo = new TriangleInfo(6, 12, 3, 4, 5,
                36.87, 53.13, 90);
        String exp = """
                Тип фигуры: TRIANGLE
                Площадь: 6 кв. см
                Периметр: 12 см
                Сторона A: 3 см
                Угол противолежащий стороне A: 36,87 град
                Сторона B: 4 см
                Угол противолежащий стороне B: 53,13 град
                Сторона C: 5 см
                Угол противолежащий стороне C: 90 град
                """;
        String act = triangleInfo.getFormattedInfo();
        assertThat(act).isEqualTo(exp);
    }
}