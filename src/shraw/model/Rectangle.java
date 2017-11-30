package shraw.model;

/**
 * @author VsSekorin
 */
public final class Rectangle implements Shape {

    private final javafx.scene.shape.Rectangle rectangle;

    public Rectangle(final double abscissa, final double ordinate) {
        this(abscissa, ordinate, 0, 0);
    }

    public Rectangle(final double abscissa, final double ordinate,
        final int width, final int height) {
        this(
            new javafx.scene.shape.Rectangle(abscissa, ordinate, width, height)
        );
    }

    public Rectangle(final javafx.scene.shape.Rectangle rect) {
        this.rectangle = rect;
    }

    @Override
    public void update(final double abscissa, final double ordinate) {
        this.rectangle.setWidth(abscissa - this.rectangle.getX());
        this.rectangle.setHeight(ordinate - this.rectangle.getY());
    }

    @Override

    public void move(final double deltaX, final double deltaY) {
        this.rectangle.setX(this.rectangle.getX() - deltaX);
        this.rectangle.setY(this.rectangle.getY() - deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return this.rectangle;
    }
}
