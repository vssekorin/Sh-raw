package shraw.fill;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public final class WithStroke implements FillStrategy {

    private final Paint color;

    public WithStroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape action(final Shape shape) {
        shape.setFill(this.color);
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(10);
        return shape;
    }

    @Override
    public FillStrategy withPaint(final Paint paint) {
        return new WithStroke(paint);
    }

    @Override
    public String text() {
        return "With Stroke";
    }
}
