package ru.shift.figures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    final static double a = 3;
    final static double b = 4;
    final static double c = 5;
    final Triangle triangle = new Triangle(List.of(a, b, c));

    @Test
    void getA() {
        double act = triangle.getA();
        assertThat(act).isEqualTo(a);
    }

    @Test
    void getB() {
        double act = triangle.getB();
        assertThat(act).isEqualTo(b);
    }

    @Test
    void getC() {
        double act = triangle.getC();
        assertThat(act).isEqualTo(c);
    }

    @Test
    void evaluateAngleAgainstA() {
        double exp = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double act = triangle.evaluateAngleAgainstA();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void evaluateAngleAgainstB() {
        double exp = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double act = triangle.evaluateAngleAgainstB();
        assertThat(act).isEqualTo(exp);

    }

    @Test
    void evaluateAngleAgainstC() {
        double exp = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
        double act = triangle.evaluateAngleAgainstC();
        assertThat(act).isEqualTo(exp);
    }


    @Test
    void whenNotATriangleThenThrowException() {
        Class<IllegalArgumentException> exp = IllegalArgumentException.class;

        List<Double> invalid1 = List.of(3d, 4d, 20d);
        assertThrows(exp, () -> new Triangle(invalid1));

        List<Double> invalid2 = List.of(-3d, 4d, 20d);
        assertThrows(exp, () -> new Triangle(invalid2));

        List<Double> invalid3 = List.of(3d, 4d, 20d, 30d);
        assertThrows(exp, () -> new Triangle(invalid3));
    }


    @Test
    void evaluateArea() {
        double p = (a + b + c) / 2;
        double exp = Math.sqrt((p * (p - a) * (p - b) * (p - c)));
        double act = triangle.evaluateArea();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void getShapeType() {
        ShapeType exp = ShapeType.TRIANGLE;
        ShapeType act = triangle.getShapeType();
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void evaluatePerimeter() {
        double exp = a + b + c;
        double act = triangle.evaluatePerimeter();
        assertThat(act).isEqualTo(exp);
    }
}