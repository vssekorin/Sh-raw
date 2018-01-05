package shraw.fill;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * @author VsSekorin
 */
public final class AsStroke implements FillStrategy {

    private Paint paint;

    @Override
    public Shape action(final Shape shape) {
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(this.paint);
        shape.setStrokeWidth(10);
        return shape;
    }

    @Override
    public FillStrategy withPaint(final Paint paint) {
        this.paint = paint;
        return this;
    }

    @Override
    public String name() {
        return "As Stroke";
    }
}
