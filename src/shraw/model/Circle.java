package shraw.model;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.util.function.Function;

import static java.lang.Math.pow;

public final class Circle implements shraw.model.Shape {

    private double pointX;

    private double pointY;

    private double radius;

    private final Function<Shape, Shape> fill;

    public Circle(final double eventX, final double eventY,
        final Function<Shape, Shape> func) {
        this.pointX = eventX;
        this.pointY = eventY;
        this.radius = 0;
        this.fill = func;
    }
    @Override
    public void update(final MouseEvent event) {
        this.radius = pow(
            pow(this.pointX - event.getX(), 2)
                + pow(this.pointY - event.getY(), 2),
            0.5
        );
    }

    @Override
    public void move(final MouseEvent event, final double x, final double y) {
        this.pointX = this.pointX + event.getX() - x;
        this.pointY = this.pointY + event.getY() - y;

    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return this.fill.apply(
            new javafx.scene.shape.Circle(
                this.pointX, this.pointY, this.radius
            )
        );
    }
}
