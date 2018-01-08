package shraw.model;

import shraw.Named;

import java.util.function.Predicate;

public interface Shape extends Named {

    void update(double abscissa, double ordinate);

    void move(double deltaX, double deltaY);

    javafx.scene.shape.Shape asShapeFX();

    Shape with(double abscissa, double ordinate);

    static Predicate<Shape> contains(final double pointX,
                                     final double pointY) {
        return shape -> shape.asShapeFX().contains(pointX, pointY);
    }

    static Predicate<Shape> isVisible() {
        return shape -> shape.asShapeFX().isVisible();
    }
}
