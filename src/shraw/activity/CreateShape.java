package shraw.activity;

import shraw.model.Shape;

/**
 * @author VsSekorin
 */
public final class CreateShape implements Activity {

    private final Shape shape;
    private final String name;

    public CreateShape(final Shape shp, final String name) {
        this.shape = shp;
        this.name = name;
    }

    @Override
    public void undo() {
        this.setVisible(false);
    }

    @Override
    public void redo() {
        this.setVisible(true);
    }

    @Override
    public String name() {
        return this.name;
    }

    private void setVisible(final boolean value) {
        this.shape.asJavaFXShape().setVisible(value);
    }
}
