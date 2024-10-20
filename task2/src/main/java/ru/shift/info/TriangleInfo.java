package ru.shift.info;

import ru.shift.figures.ShapeType;

public class TriangleInfo extends FigureInfo {
    private final double a;
    private final double b;
    private final double c;

    private final double angleAgainstA;
    private final double angleAgainstB;
    private final double angleAgainstC;

    static final ShapeType shapeType = ShapeType.TRIANGLE;

    public TriangleInfo(double area, double perimeter, double a, double b, double c,
                        double angleAgainstA, double angleAgainstB, double angleAgainstC) {
        super(shapeType, area, perimeter);

        this.a = a;
        this.b = b;
        this.c = c;

        this.angleAgainstA = angleAgainstA;
        this.angleAgainstB = angleAgainstB;
        this.angleAgainstC = angleAgainstC;
    }


    @Override
    public String getFormattedInfo() {
        String sideA = lineFormatter.formatLineTriangleSideAndAngle(a, angleAgainstA, Side.A);
        String sideB = lineFormatter.formatLineTriangleSideAndAngle(b, angleAgainstB, Side.B);
        String sideC = lineFormatter.formatLineTriangleSideAndAngle(c, angleAgainstC, Side.C);

        return super.getFormattedInfo() + sideA + sideB + sideC;
    }

    //для удобства работы с LineFormatter
    public enum Side {
        A,
        B,
        C
    }
}
