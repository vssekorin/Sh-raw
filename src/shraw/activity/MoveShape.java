package shraw.activity;

import shraw.model.Shape;

/**
 * Действие перемещение фигуры.
 */
public final class MoveShape implements Activity {

    /**
     * JavaFX фигура.
     */
    private final javafx.scene.shape.Shape shape;

    /**
     * Разница по x.
     */
    private final double deltaX;

    /**
     * Разница по y.
     */
    private final double deltaY;

    /**
     * Ctor.
     * @param shape Фигура
     * @param deltaX Разница по x
     * @param deltaY Разница по y
     */
    public MoveShape(final Shape shape, final double deltaX, final double deltaY) {
        this.shape = shape.asShapeFX();
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    @Override
    public void undo() {
        shape.setTranslateX(shape.getTranslateX() - deltaX);
        shape.setTranslateY(shape.getTranslateY() - deltaY);
    }

    @Override
    public void redo() {
        shape.setTranslateX(shape.getTranslateX() + deltaX);
        shape.setTranslateY(shape.getTranslateY() + deltaY);
    }
}
