package ru.shift.figures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    final static double a = 3;
    final static double b = 12;
    final Rectangle rectangle = new Rectangle(List.of(a, b));


    @Test
    void evaluateArea() {
        double exp = a * b;
        double act = rectangle.evaluateArea();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getShapeType() {
        ShapeType exp = ShapeType.RECTANGLE;
        ShapeType act = rectangle.getShapeType();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void evaluatePerimeter() {
        double exp = 2 * (a + b);
        double act = rectangle.evaluatePerimeter();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getA() {
        double exp = Math.max(a, b);
        double act = rectangle.getA();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getB() {
        double exp = Math.min(a, b);
        double act = rectangle.getB();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getDiagonal() {
        double exp = Math.sqrt(a * a + b * b);
        double act = rectangle.getDiagonal();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void whenNotARectangleThenThrowException() {
        Class<IllegalArgumentException> exp = IllegalArgumentException.class;

        List<Double> invalid1 = List.of(-3d, 4d);
        assertThrows(exp, () -> new Rectangle(invalid1));

        List<Double> invalid2 = List.of(3d, 4d, 3d);
        assertThrows(exp, () -> new Rectangle(invalid2));
    }
}
