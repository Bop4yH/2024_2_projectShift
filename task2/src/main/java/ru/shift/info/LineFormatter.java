package ru.shift.info;

import ru.shift.figures.ShapeType;

import java.text.DecimalFormat;

public class LineFormatter implements LineFormatterInterface {
    private final int precision;

    //можно добавить кастомные юниты при желании
    private static final String UNIT_CM = " см";
    private static final String ANGLE_GRAD = " град";
    private static final int DEFAULT_PRECISION = 2;

    public LineFormatter(int precision) {
        this.precision = precision;
    }

    public LineFormatter() {
        this(DEFAULT_PRECISION);
    }

    @Override
    public String formatLineShapeType(ShapeType shapeType) {
        return String.format("Тип фигуры: %s\n", shapeType);
    }

    @Override
    public String formatLineDataWithLabel(String label, double data) {
        return String.format("%s%s%s\n", label, formatDouble(data), UNIT_CM);
    }

    @Override
    public String formatLineDataWithLabel(String label, double data, String prefix) {
        return String.format("%s%s%s%s\n", label, formatDouble(data), prefix, UNIT_CM);
    }

    public String formatLineTriangleSideAndAngle(double side, double angle, TriangleInfo.Side sideName) {
        return String.format("Сторона %s: %s%s\n", sideName, formatDouble(side), UNIT_CM) +
                String.format("Угол противолежащий стороне %s: %s%s\n", sideName, formatDouble(angle), ANGLE_GRAD);
    }

    private String formatDouble(double value) {
        return formatDouble(value, precision);
    }

    public static String formatDouble(double value, int decimalPlaces) {
        DecimalFormat decimalFormat = new DecimalFormat("#." + "#".repeat(Math.max(0, decimalPlaces)));
        return decimalFormat.format(value);
    }
}
