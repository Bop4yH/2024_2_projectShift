package ru.shift.figures;

import java.util.List;

public class Circle extends Figure {
    private static final ShapeType SHAPE_TYPE = ShapeType.CIRCLE;
    private static final int ATTRIBUTES_AMOUNT = 1;

    private final double radius;

    public Circle(List<Double> params) {
        super(params);
        this.radius = params.get(0);
    }

    @Override
    public double evaluatePerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public double evaluateArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public ShapeType getShapeType() {
        return SHAPE_TYPE;
    }

    @Override
    public int getAttributesAmount() {
        return ATTRIBUTES_AMOUNT;
    }

    public double getRadius() {
        return radius;
    }

    public double evaluateDiameter() {
        return 2 * radius;
    }
}
