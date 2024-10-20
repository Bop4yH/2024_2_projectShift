package ru.shift.figures;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Figure {
    private static final ShapeType SHAPE_TYPE = ShapeType.TRIANGLE;
    private static final int ATTRIBUTES_AMOUNT = 3;

    private final double a;
    private final double b;
    private final double c;

    public Triangle(List<Double> params) {
        super(params);

        this.a = params.get(0);
        this.b = params.get(1);
        this.c = params.get(2);
    }

    static private boolean isTriangle(List<Double> params) {
        List<Double> sortedParams = new ArrayList<>(params);
        sortedParams.sort(null);
        return sortedParams.get(0) + sortedParams.get(1) > sortedParams.get(2);
    }

    @Override
    protected boolean isNotValidAttributes(List<Double> params) {
        return super.isNotValidAttributes(params) || !isTriangle(params);
    }

    @Override
    public int getAttributesAmount() {
        return ATTRIBUTES_AMOUNT;
    }

    @Override
    public double evaluatePerimeter() {
        return a + b + c;
    }

    @Override
    public double evaluateArea() {
        double p = evaluatePerimeter() / 2;
        return Math.sqrt((p * (p - a) * (p - b) * (p - c)));
    }

    @Override
    public ShapeType getShapeType() {
        return SHAPE_TYPE;
    }

    static private double evaluateAngle(double sideToCalculateAngleAgainst, double sideA, double sideB) {
        double numerator = sideA * sideA + sideB * sideB
                - sideToCalculateAngleAgainst * sideToCalculateAngleAgainst;
        double denominator = 2 * sideA * sideB;
        return Math.toDegrees(Math.acos(numerator / denominator));

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double evaluateAngleAgainstA() {
        return evaluateAngle(a, b, c);
    }

    public double evaluateAngleAgainstB() {
        return evaluateAngle(b, a, c);
    }

    public double evaluateAngleAgainstC() {
        return evaluateAngle(c, a, b);
    }


}
