package shraw.model;

import javafx.scene.input.MouseEvent;

import java.util.function.Predicate;

/**
 * @author VsSekorin
 */
public interface Shape {

    void update(MouseEvent event);

    void move(MouseEvent event, double x, double y);

    javafx.scene.shape.Shape asJavaFXShape();

    static Predicate<Shape> contains(final double x, final double y) {
        return shape -> shape.asJavaFXShape().contains(x, y);
    }
}
