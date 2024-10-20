package ru.shift.info;

import ru.shift.figures.ShapeType;

//используется как record, стоит ли заменить на record?
public abstract class FigureInfo {
    private final ShapeType shapeType;
    private final double area;
    private final double perimeter;

    protected LineFormatter lineFormatter = new LineFormatter();

    public FigureInfo(ShapeType shapeType, double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
        this.shapeType = shapeType;
    }

    public String getFormattedInfo() {
        return lineFormatter.formatLineShapeType(shapeType) +
                lineFormatter.formatLineDataWithLabel("Площадь: ", area, " кв.") +
                lineFormatter.formatLineDataWithLabel("Периметр: ", perimeter);
    }
}
