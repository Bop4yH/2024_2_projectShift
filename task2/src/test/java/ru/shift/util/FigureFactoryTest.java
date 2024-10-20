package ru.shift.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {

    @Test
    void createFigureWhenInvalidShapeTypeThenNull() {
        ShapeLabel label = new ShapeLabel("IAMCIRCLE!", "5");
        assertThat(FigureFactory.createFigure(label)).isNull();
    }

    @Test
    void createFigureWhenInvalidParametersThenNull() {
        ShapeLabel label1 = new ShapeLabel("CIRCLE", "5 10");
        assertThat(FigureFactory.createFigure(label1)).isNull();

        ShapeLabel label2 = new ShapeLabel("CIRCLE", "0.010q");
        assertThat(FigureFactory.createFigure(label2)).isNull();
    }

}