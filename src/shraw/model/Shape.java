package shraw.model;

import java.util.function.Predicate;

/**
 * @author VsSekorin
 */
public interface Shape {

    void update(double abscissa, double ordinate);

    void move(double deltaX, double deltaY);

    javafx.scene.shape.Shape asJavaFXShape();

    static Predicate<Shape> contains(final double pointX,
        final double pointY) {
        return shape -> shape.asJavaFXShape().contains(pointX, pointY);
    }

    static Predicate<Shape> isVisible() {
        return shape -> shape.asJavaFXShape().isVisible();
    }
}
