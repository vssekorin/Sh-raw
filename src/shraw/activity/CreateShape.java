package shraw.activity;

import shraw.model.Shape;

/**
 * Действие создания фигуры.
 */
public final class CreateShape implements Activity {

    /**
     * JavaFX фигура.
     */
    private final javafx.scene.shape.Shape shape;

    /**
     * Ctor.
     * @param shape Фигура
     */
    public CreateShape(final Shape shape) {
        this.shape = shape.asShapeFX();
    }

    @Override
    public void undo() {
        this.shape.setVisible(false);
    }

    @Override
    public void redo() {
        this.shape.setVisible(true);
    }
}
