package ru.shift.info;

import ru.shift.figures.ShapeType;

public class CircleInfo extends FigureInfo {
    private final double radius;
    private final double diameter;
    static final ShapeType shapeType = ShapeType.CIRCLE;

    public CircleInfo(double area, double perimeter, double radius, double diameter) {
        super(shapeType, area, perimeter);
        this.radius = radius;
        this.diameter = diameter;
    }

    @Override
    public String getFormattedInfo() {
        return super.getFormattedInfo() +
                lineFormatter.formatLineDataWithLabel("Радиус: ", radius) +
                lineFormatter.formatLineDataWithLabel("Диаметр: ", diameter);
    }


}
