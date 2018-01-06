package shraw.model;

import shraw.fill.FillStrategy;
import shraw.fill.Stroke;

import static java.lang.Math.pow;

public final class Circle implements Shape {

    private final javafx.scene.shape.Circle shape;

    private final FillStrategy strategy;

    public Circle(final double abscissa, final double ordinate) {
        this(abscissa, ordinate, new Stroke());
    }

    public Circle(final double abscissa, final double ordinate,
                  final FillStrategy strategy) {
        this(abscissa, ordinate, 0, strategy);
    }

    public Circle(final double abscissa, final double ordinate,
                  final double radius, final FillStrategy strategy) {
        this.shape = new javafx.scene.shape.Circle(abscissa, ordinate, radius);
        this.strategy = strategy;
    }

    @Override
    public void update(final double abscissa, final double ordinate) {
        final double deltaX = this.shape.getCenterX() - abscissa;
        final double deltaY = this.shape.getCenterY() - ordinate;
        this.shape.setRadius(pow(pow(deltaX, 2) + pow(deltaY, 2), 0.5));
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.shape.setCenterX(this.shape.getCenterX() - deltaX);
        this.shape.setCenterY(this.shape.getCenterY() - deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return this.strategy.action(this.shape);
    }

    @Override
    public Shape like(double abscissa, double ordinate, FillStrategy strategy) {
        return new Circle(abscissa, ordinate, strategy);
    }

    @Override
    public String text() {
        return "Circle";
    }
}
