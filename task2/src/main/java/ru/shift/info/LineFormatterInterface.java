package ru.shift.info;

import ru.shift.figures.ShapeType;

public interface LineFormatterInterface {
    String formatLineShapeType(ShapeType shapeType);

    String formatLineDataWithLabel(String label, double data);

    String formatLineDataWithLabel(String label, double data, String prefix);

}
