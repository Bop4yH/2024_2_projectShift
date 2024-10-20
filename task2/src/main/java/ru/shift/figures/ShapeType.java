package ru.shift.figures;

public enum ShapeType {
    CIRCLE(Circle.class),
    RECTANGLE(Rectangle.class),
    TRIANGLE(Triangle.class);

    private final Class<? extends Figure> figureClass;

    ShapeType(Class<? extends Figure> figureClass) {
        this.figureClass = figureClass;
    }

    public Class<? extends Figure> getFigureClass() {
        return figureClass;
    }
}
