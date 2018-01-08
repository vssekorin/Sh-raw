package shraw.model;

import lombok.val;

import static java.lang.Math.pow;

public final class Circle implements Shape {

    private final javafx.scene.shape.Circle shape;

    public Circle(final double abscissa, final double ordinate) {
        this(abscissa, ordinate, 0);
    }

    public Circle(final double abscissa, final double ordinate,
                  final double radius) {
        this.shape = new javafx.scene.shape.Circle(abscissa, ordinate, radius);
    }

    @Override
    public void update(final double abscissa, final double ordinate) {
        val deltaX = this.shape.getCenterX() - abscissa;
        val deltaY = this.shape.getCenterY() - ordinate;
        this.shape.setRadius(pow(pow(deltaX, 2) + pow(deltaY, 2), 0.5));
    }

    @Override
    public void move(final double deltaX, final double deltaY) {
        this.shape.setCenterX(this.shape.getCenterX() - deltaX);
        this.shape.setCenterY(this.shape.getCenterY() - deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asShapeFX() {
        return this.shape;
    }

    @Override
    public Shape with(double abscissa, double ordinate) {
        return new Circle(abscissa, ordinate);
    }

    @Override
    public String text() {
        return "Circle";
    }
}
