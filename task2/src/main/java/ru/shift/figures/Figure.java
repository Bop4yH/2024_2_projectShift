package ru.shift.figures;

import java.util.List;

import static ru.shift.Main.log;

public abstract class Figure implements Calculable {

    public abstract double evaluatePerimeter();

    public abstract double evaluateArea();

    public abstract ShapeType getShapeType();

    public abstract int getAttributesAmount();

    Figure(List<Double> params){
        checkAttributes(params);
    }

    protected  boolean isNotValidAttributes(List<Double> params) {
        return params.size() != getAttributesAmount() || !params.stream().allMatch(n -> n > 0);
    }

    protected final void checkAttributes(List<Double> params) {
        if (isNotValidAttributes(params)) {
            log.error("Неудачная попытка создать {} из {}", getShapeType(), params);
            throw new IllegalArgumentException();
        }
    }
}




