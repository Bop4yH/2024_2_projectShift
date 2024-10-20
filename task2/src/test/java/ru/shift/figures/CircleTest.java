package ru.shift.figures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {
    final static double radius = 10;
    final Circle circle = new Circle(List.of(radius));

    @Test
    void getRadius() {
        double act = circle.getRadius();
        assertThat(act).isEqualTo(radius);
    }

    @Test
    void evaluateArea() {
        double exp = radius * radius * Math.PI;
        double act = circle.evaluateArea();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getShapeType() {
        ShapeType exp = ShapeType.CIRCLE;
        ShapeType act = circle.getShapeType();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void evaluatePerimeter() {
        double exp = 2 * Math.PI * radius;
        double act = circle.evaluatePerimeter();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void evaluateDiameter() {
        double exp = radius * 2;
        double act = circle.evaluateDiameter();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void whenNotACircleThenThrowException() {
        Class<IllegalArgumentException> exp = IllegalArgumentException.class;

        List<Double> invalid1 = List.of(-3d);
        assertThrows(exp, () -> new Circle(invalid1));

        List<Double> invalid2 = List.of(3d, 4d);
        assertThrows(exp, () -> new Circle(invalid2));
    }
}