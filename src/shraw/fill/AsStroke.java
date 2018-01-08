package shraw.fill;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public final class AsStroke implements FillStrategy {

    private final Paint color;

    public AsStroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape action(final Shape shape) {
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(this.color);
        shape.setStrokeWidth(10);
        return shape;
    }

    @Override
    public FillStrategy withPaint(final Paint paint) {
        return new AsStroke(paint);
    }

    @Override
    public String text() {
        return "As Stroke";
    }
}
