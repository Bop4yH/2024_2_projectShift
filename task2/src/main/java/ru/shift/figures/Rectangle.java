package ru.shift.figures;

import java.util.Collections;
import java.util.List;

public class Rectangle extends Figure {
    private static final ShapeType SHAPE_TYPE = ShapeType.RECTANGLE;
    private static final int ATTRIBUTES_AMOUNT = 2;

    private final double a;
    private final double b;


    public Rectangle(List<Double> params) {
        super(params);
        this.a = Collections.max(params);
        this.b = Collections.min(params);
    }


    @Override
    public double evaluatePerimeter() {
        return 2 * (a + b);
    }

    @Override
    public double evaluateArea() {
        return a * b;
    }

    @Override
    public ShapeType getShapeType() {
        return SHAPE_TYPE;
    }

    @Override
    public int getAttributesAmount() {
        return ATTRIBUTES_AMOUNT;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getDiagonal() {
        return Math.sqrt(a * a + b * b);
    }
}

