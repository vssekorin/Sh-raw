package shraw.model;

import shraw.fill.FillStrategy;
import shraw.fill.Stroke;

/**
 * @author VsSekorin
 */
public final class Rectangle implements Shape {

    private final javafx.scene.shape.Rectangle shape;

    private final FillStrategy strategy;

    public Rectangle(final double abscissa, final double ordinate) {
        this(abscissa, ordinate, 0, 0, new Stroke());
    }

    public Rectangle(final double abscissa, final double ordinate,
                     final FillStrategy strategy) {
        this(abscissa, ordinate, 0, 0, strategy);
    }

    public Rectangle(final double abscissa, final double ordinate,
        final int width, final int height, final FillStrategy strategy) {
        this.shape =
            new javafx.scene.shape.Rectangle(abscissa, ordinate, width, height);
        this.strategy = strategy;
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
    public javafx.scene.shape.Shape asJavaFXShape() {
        return this.strategy.action(this.shape);
    }

    @Override
    public Shape like(final double abscissa, final double ordinate, final FillStrategy strategy) {
        return new Rectangle(abscissa, ordinate, strategy);
    }

    @Override
    public String name() {
        return "Rectangle";
    }
}
