package shraw.fill;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public final class Stroke implements FillStrategy {

    private final Paint color;

    public Stroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape action(final Shape shape) {
        shape.setFill(this.color);
        return shape;
    }

    @Override
    public FillStrategy withPaint(final Paint paint) {
        return new Stroke(paint);
    }

    @Override
    public String text() {
        return "Stroke";
    }
}
