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
        this.secondX = this.firstX = eventX;
        this.secondY = this.firstY = eventY;
    }

    @Override
    public void update(final MouseEvent event) {
        secondX = event.getX();
        secondY = event.getY();
    }

    @Override
    public void move(final MouseEvent event, double x, double y) {
        System.out.println(x + " " + y + " " + (event.getX() - x) + " " + (event.getY() - y));
        this.firstX = firstX + event.getX() - x;
        this.firstY = firstY + event.getY() - y;
        this.secondX = secondX + event.getX() - x;
        this.secondY = secondY + event.getY() - y;
    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return new javafx.scene.shape.Rectangle(
                Math.min(firstX, secondX), Math.min(firstY, secondY), Math.abs(firstX - secondX), Math.abs(firstY - secondY)
        );
    }
}
