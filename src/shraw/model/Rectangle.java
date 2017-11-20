package shraw.model;

import javafx.scene.input.MouseEvent;

/**
 * @author VsSekorin
 */
public final class Rectangle implements Shape {

    private double firstX;

    private double firstY;

    private double secondX;

    private double secondY;

    public Rectangle(final double eventX, final double eventY) {
        this.firstX = this.secondX = eventX;
        this.firstY = this.secondY = eventY;
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
    public javafx.scene.shape.Shape asJavaFXShape() {
        return new javafx.scene.shape.Rectangle(
            Math.min(this.firstX, this.secondX),
            Math.min(this.firstY, this.secondY),
            Math.abs(this.firstX - this.secondX),
            Math.abs(this.firstY - this.secondY)
        );
    }
}
