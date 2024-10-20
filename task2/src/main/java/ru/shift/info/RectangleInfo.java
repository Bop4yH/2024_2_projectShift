package ru.shift.info;

import ru.shift.figures.ShapeType;

public class RectangleInfo extends FigureInfo {
    private final double a;
    private final double b;
    private final double diagonal;

    static final ShapeType shapeType = ShapeType.RECTANGLE;

    public RectangleInfo(double area, double perimeter, double a, double b, double diagonal) {
        super(shapeType, area, perimeter);
        this.a = a;
        this.b = b;
        this.diagonal = diagonal;
    }

    @Override
    public String getFormattedInfo() {
        return super.getFormattedInfo() +
                lineFormatter.formatLineDataWithLabel("Длина диагонали: ", diagonal) +
                lineFormatter.formatLineDataWithLabel("Длина: ", a) +
                lineFormatter.formatLineDataWithLabel("Ширина: ", b);
    }
}
