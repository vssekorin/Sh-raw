package shraw.model;

import shraw.fill.FillStrategy;

public final class StylishShape implements Shape {

    private final Shape origin;

    private final FillStrategy strategy;

    public StylishShape(final Shape shape, final FillStrategy strategy) {
        this.origin = shape;
        this.strategy = strategy;
    }

    @Override
    public void update(double abscissa, double ordinate) {
        this.origin.update(abscissa, ordinate);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.origin.move(deltaX, deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asShapeFX() {
        return this.strategy.action(this.origin.asShapeFX());
    }

    @Override
    public Shape with(double abscissa, double ordinate) {
        return this.origin.with(abscissa, ordinate);
    }

    @Override
    public String text() {
        return this.origin.text();
    }
}
