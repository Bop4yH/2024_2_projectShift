package ru.shift.info;

import ru.shift.figures.Circle;
import ru.shift.figures.Figure;
import ru.shift.figures.Rectangle;
import ru.shift.figures.Triangle;

import static ru.shift.Main.log;

//не нравится этот класс из-за повторения кода, но я не знаю как сделать лучше
public class InfoMaker {
    public static FigureInfo makeInfo(Figure figure) {
        if (figure == null){
            return null;
        }

        switch (figure.getShapeType()) {
            case CIRCLE -> {return makeInfo((Circle) figure);}
            case RECTANGLE -> {return makeInfo((Rectangle) figure);}
            case TRIANGLE -> {return makeInfo((Triangle) figure);}
            default -> {
                log.debug("Unknown shape type: {}", figure.getShapeType());
                return null;
            }
        }
    }


    private static CircleInfo makeInfo(Circle circle) {
        double area = circle.evaluateArea();
        double perimeter = circle.evaluatePerimeter();
        return new CircleInfo(area, perimeter, circle.getRadius(), circle.evaluateDiameter());
    }

    private static RectangleInfo makeInfo(Rectangle rectangle) {
        double area = rectangle.evaluateArea();
        double perimeter = rectangle.evaluatePerimeter();
        return new RectangleInfo(area, perimeter, rectangle.getA(), rectangle.getB(), rectangle.getDiagonal());
    }

    private static TriangleInfo makeInfo(Triangle triangle) {
        double area = triangle.evaluateArea();
        double perimeter = triangle.evaluatePerimeter();
        return new TriangleInfo(area, perimeter, triangle.getA(), triangle.getB(), triangle.getC(),
                triangle.evaluateAngleAgainstA(), triangle.evaluateAngleAgainstB(), triangle.evaluateAngleAgainstC());
    }
}
