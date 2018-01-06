package shraw.activity;

import shraw.model.Shape;

public final class CreateShape implements Activity {

    private final Shape shape;

    public CreateShape(final Shape shape) {
        this.shape = shape;
    }

    @Override
    public void undo() {
        this.setVisible(false);
    }

    @Override
    public void redo() {
        this.setVisible(true);
    }

    private void setVisible(final boolean value) {
        this.shape.asJavaFXShape().setVisible(value);
    }
}
