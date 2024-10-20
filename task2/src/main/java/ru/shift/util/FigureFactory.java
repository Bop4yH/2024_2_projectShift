package ru.shift.util;

import ru.shift.figures.Figure;
import ru.shift.figures.ShapeType;

import java.util.ArrayList;
import java.util.List;

import static ru.shift.Main.log;

public class FigureFactory {
    public static Figure createFigure(ShapeLabel shapeLabel) {
        ShapeType shapeType = toShapeType(shapeLabel.tagName());
        if (shapeType == null) {
            return null;
        }

        var paramsList = toDoubleList(shapeLabel.labelText());
        if (paramsList == null) {
            return null;
        }

        try {
            //ожидаем что все ошибки будут обработаны в конструкторе при создании
            return shapeType.getFigureClass().getDeclaredConstructor(List.class).newInstance(paramsList);
        } catch (Exception e) {
            return null;
        }
    }

    private static ShapeType toShapeType(String labelShapeType) {
        try {
            return ShapeType.valueOf(labelShapeType);
        } catch (IllegalArgumentException e) {
            log.error("Не удалось преобразовать строку {} к типу фигуры", labelShapeType);
            return null;
        }
    }

    private static List<Double> toDoubleList(String parameters) {
        String[] stringArr = parameters.split(" ");
        List<Double> doubleList = new ArrayList<>();

        for (String str : stringArr) {
            try {
                doubleList.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {
                log.error("Не удалось прочитать число: {}", str);
                return null;
            }
        }
        return doubleList;
    }
}