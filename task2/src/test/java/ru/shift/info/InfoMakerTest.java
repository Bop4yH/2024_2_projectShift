package ru.shift.info;

import org.junit.jupiter.api.Test;
import ru.shift.figures.Circle;
import ru.shift.figures.Rectangle;
import ru.shift.figures.Triangle;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InfoMakerTest {
    final Circle CircleFigure = new Circle(List.of(5d));
    final Rectangle RectangleFigure = new Rectangle(List.of(5d, 10d));
    final Triangle TriangleFigure = new Triangle(List.of(3d, 4d, 5d));

    @Test
    void makeInfoCaseCircle() {
        FigureInfo act = InfoMaker.makeInfo(CircleFigure);
        assertThat(act).isExactlyInstanceOf(CircleInfo.class);
    }

    @Test
    void makeInfoCaseRectangle() {
        FigureInfo act = InfoMaker.makeInfo(RectangleFigure);
        assertThat(act).isExactlyInstanceOf(RectangleInfo.class);
    }

    @Test
    void makeInfoCaseTriangle() {
        FigureInfo act = InfoMaker.makeInfo(TriangleFigure);
        assertThat(act).isExactlyInstanceOf(TriangleInfo.class);
    }

    @Test
    void whenNullThenReturnNull() {

        FigureInfo act = InfoMaker.makeInfo(null);
        assertThat(act).isNull();
    }
}