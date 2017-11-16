package shraw.model;

import javafx.scene.input.MouseEvent;

/**
 * @author VsSekorin
 */
public final class Rectangle implements Shape {

    private double x;

    private double y;

    private double height;

    private double width;

    public Rectangle(final double eventX, final double eventY) {
        this.x = eventX;
        this.y = eventY;
        this.height = 0;
        this.width = 0;
    }

    @Override
    public void update(final MouseEvent event) {
        this.width = Math.abs(x - event.getX());
        this.height = Math.abs(y - event.getY());
        this.x = Math.min(x, event.getX());
        this.y = Math.min(y, event.getY());
    }

    @Override
    public void move(final MouseEvent event) {
        this.x = event.getX();
        this.y = event.getY();
    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return new javafx.scene.shape.Rectangle(
            this.x, this.y, this.width, this.height
        );
    }
}
