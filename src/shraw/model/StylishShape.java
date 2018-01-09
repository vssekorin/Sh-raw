package shraw.model;

import shraw.fill.FillStrategy;

/**
 * Фигура с раскраской.
 */
public final class StylishShape implements Shape {

    /**
     * Фигура.
     */
    private final Shape origin;

    /**
     * Стратегия раскраски.
     */
    private final FillStrategy strategy;

    /**
     * Ctor.
     * @param shape Фигура
     * @param strategy Стратегия раскраски
     */
    public StylishShape(final Shape shape, final FillStrategy strategy) {
        this.origin = shape;
        this.strategy = strategy;
    }

    @Override
    public void update(final double abscissa, final double ordinate) {
        this.origin.update(abscissa, ordinate);
    }

    @Override
    public void move(final double deltaX, final double deltaY) {
        this.origin.move(deltaX, deltaY);
    }

    @Override
    public javafx.scene.shape.Shape asShapeFX() {
        return this.strategy.apply(this.origin.asShapeFX());
    }

    @Override
    public Shape with(final double abscissa, final double ordinate) {
        return this.origin.with(abscissa, ordinate);
    }

    @Override
    public String text() {
        return this.origin.text();
    }
}
