package shraw;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author VsSekorin
 */
public final class FillStrategy {

    private FillStrategy() {
    }

    private static Pair<Function<Paint, Function<Shape, Shape>>, String> simple =
        new Pair<>(paint -> shape -> {
            shape.setFill(paint);
            return shape;
        }, "Simple");

    private static Pair<Function<Paint, Function<Shape, Shape>>, String> asStroke =
        new Pair<>(paint -> shape -> {
            shape.setFill(Color.TRANSPARENT);
            shape.setStroke(paint);
            shape.setStrokeWidth(10);
            return shape;
        }, "As Stroke");

    private static Pair<Function<Paint, Function<Shape, Shape>>, String> withStroke =
        new Pair<>(paint -> shape -> {
            shape.setFill(paint);
            shape.setStroke(Color.BLACK);
            shape.setStrokeWidth(10);
            return shape;
        }, "With Stroke");

    private static final List<Pair<Function<Paint, Function<Shape, Shape>>, String>> ALL =
        Arrays.asList(simple, asStroke, withStroke);

    public static List<Function<Paint, Function<Shape, Shape>>> funcs =
        ALL.stream().map(Pair::getKey).collect(Collectors.toList());

    public static final StringConverter<Function<Paint, Function<Shape, Shape>>> stringConverter =
        new StringConverter<Function<Paint, Function<Shape, Shape>>>() {
        @Override
        public String toString(Function<Paint, Function<Shape, Shape>> func) {
            return ALL.stream()
                .filter(item -> item.getKey().equals(func))
                .findFirst()
                .map(Pair::getValue)
                .orElseThrow(IllegalStateException::new);
        }

        @Override
        public Function<Paint, Function<Shape, Shape>> fromString(String s) {
            throw new UnsupportedOperationException();
        }
    };
}
