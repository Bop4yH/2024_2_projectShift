package ru.shift.figures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeTypeTest {

    @Test
    void getFigureClass() {
        Class<Circle> exp1 = Circle.class;
        Class<Rectangle> exp2 = Rectangle.class;
        Class<Triangle> exp3 = Triangle.class;

        Class<? extends Figure> act1 = ShapeType.CIRCLE.getFigureClass();
        Class<? extends Figure> act2 = ShapeType.RECTANGLE.getFigureClass();
        Class<? extends Figure> act3 = ShapeType.TRIANGLE.getFigureClass();

        assertThat(exp1).isEqualTo(act1);
        assertThat(exp2).isEqualTo(act2);
        assertThat(exp3).isEqualTo(act3);
    }


}