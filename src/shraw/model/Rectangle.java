package shraw.model;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.util.function.Function;

/**
 * @author VsSekorin
 */
public final class Rectangle implements shraw.model.Shape {

    private double firstX;

    private double firstY;

    private double secondX;

    private double secondY;

    private final Function<Shape, Shape> fill;

    public Rectangle(final double eventX, final double eventY,
        final Function<Shape, Shape> func) {
        this.firstX = this.secondX = eventX;
        this.firstY = this.secondY = eventY;
        this.fill = func;
    }

    @Override
    public void update(final MouseEvent event) {
        this.secondX = event.getX();
        this.secondY = event.getY();
    }

    @Override
    public void move(final MouseEvent event, final double x, final double y) {
        this.firstX += event.getX() - x;
        this.firstY += event.getY() - y;
        this.secondX += event.getX() - x;
        this.secondY += event.getY() - y;
    }

    @Override
    public Shape asJavaFXShape() {
        return this.fill.apply(
            new javafx.scene.shape.Rectangle(
                Math.min(this.firstX, this.secondX),
                Math.min(this.firstY, this.secondY),
                Math.abs(this.firstX - this.secondX),
                Math.abs(this.firstY - this.secondY)
            )
        );
    }
}
