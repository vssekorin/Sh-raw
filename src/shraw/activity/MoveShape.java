package shraw.activity;

import shraw.model.Shape;

public final class MoveShape implements Activity {

    private final javafx.scene.shape.Shape shape;

    private final double deltaX;

    private final double deltaY;

    public MoveShape(Shape shape, double deltaX, double deltaY) {
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
