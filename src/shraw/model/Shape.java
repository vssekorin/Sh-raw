package shraw.model;

import shraw.Named;
import shraw.fill.FillStrategy;

import java.util.function.Predicate;

/**
 * @author VsSekorin
 */
public interface Shape extends Named {

    void update(double abscissa, double ordinate);

    void move(double deltaX, double deltaY);

    javafx.scene.shape.Shape asJavaFXShape();

    Shape like(double abscissa, double ordinate, FillStrategy strategy);

    static Predicate<Shape> contains(final double pointX,
        final double pointY) {
        return shape -> shape.asJavaFXShape().contains(pointX, pointY);
    }

    static Predicate<Shape> isVisible() {
        return shape -> shape.asJavaFXShape().isVisible();
    }
}
