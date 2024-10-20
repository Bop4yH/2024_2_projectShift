package ru.shift.util;

import ru.shift.figures.*;
import ru.shift.info.FigureInfo;
import ru.shift.info.InfoMaker;
import ru.shift.io.ShapeLabelReader;

public class LabelParser {
    public static FigureInfo parseToInfo(ShapeLabelReader reader) {
        try {
            ShapeLabel shapeLabel = reader.readShapeLabel();
            Figure figure = FigureFactory.createFigure(shapeLabel);
            return InfoMaker.makeInfo(figure);
        } catch (Exception e) {
            return null;
        }
    }
}
