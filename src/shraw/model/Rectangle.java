package shraw.model;

/**
 * Прямоугольник.
 */
public final class Rectangle implements Shape {

    /**
     * JavaFX прямоугольник.
     */
    private final javafx.scene.shape.Rectangle shape;

    /**
     * Ctor.
     * @param abscissa Координата x
     * @param ordinate Координата y
     */
    public Rectangle(final double abscissa, final double ordinate) {
        this(abscissa, ordinate, 0, 0);
    }

    /**
     * Ctor.
     * @param abscissa Координата x
     * @param ordinate Координата y
     * @param width Ширина
     * @param height Высота
     */
    public Rectangle(final double abscissa, final double ordinate,
                     final int width, final int height) {
        this.shape = new javafx.scene.shape.Rectangle(
            abscissa, ordinate, width, height
        );
    }

    @Override
    public void update(final double abscissa, final double ordinate) {
        this.shape.setWidth(abscissa - this.shape.getX());
        this.shape.setHeight(ordinate - this.shape.getY());
    }

    @Override
    public void move(final double deltaX, final double deltaY) {
        this.shape.setX(this.shape.getX() - deltaX);
        this.shape.setY(this.shape.getY() - deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asShapeFX() {
        return this.shape;
    }

    @Override
    public Shape with(final double abscissa, final double ordinate) {
        return new Rectangle(abscissa, ordinate);
    }

    @Override
    public String text() {
        return "Rectangle";
    }
}
