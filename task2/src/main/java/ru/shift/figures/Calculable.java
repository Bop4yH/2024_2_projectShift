package ru.shift.figures;

public interface Calculable {
    double evaluatePerimeter();

    double evaluateArea();

    ShapeType getShapeType();

    int getAttributesAmount();
}
