package shraw;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

import java.util.function.Function;

/**
 * @author VsSekorin
 */
public final class FillStrategy {

    private FillStrategy() {
    }

    public static Function<Paint, Function<Shape, Shape>> simple() {
        return paint -> shape -> {
            shape.setFill(paint);
            return shape;
        };
    }

    public static Function<Paint, Function<Shape, Shape>> asStroke() {
        return paint -> shape -> {
            shape.setFill(Color.TRANSPARENT);
            shape.setStroke(paint);
            shape.setStrokeWidth(10);
            return shape;
        };
    }

    public static Function<Paint, Function<Shape, Shape>> withStroke() {
        return paint -> shape -> {
            shape.setFill(paint);
            shape.setStroke(Color.BLACK);
            shape.setStrokeWidth(10);
            return shape;
        };
    }
}
