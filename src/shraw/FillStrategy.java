package shraw;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.List;
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

    public static final List<Function<Paint, Function<Shape, Shape>>> all =
        Arrays.asList(simple(), asStroke(), withStroke());

    public static final StringConverter<Function<Paint, Function<Shape, Shape>>> stringConverter =
        new StringConverter<Function<Paint, Function<Shape, Shape>>>() {
        @Override
        public String toString(Function<Paint, Function<Shape, Shape>> func) {
            if (func.equals(simple())) {
                return "Simple";
            }
            if (func.equals(asStroke())) {
                return "asStroke";
            }
            if (func.equals(withStroke())) {
                return "withStroke";
            }
            throw new IllegalStateException();
        }

        @Override
        public Function<Paint, Function<Shape, Shape>> fromString(String s) {
            throw new UnsupportedOperationException();
        }
    };
}
