package shraw.fill;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * @author VsSekorin
 */
public final class Stroke implements FillStrategy {

    private Paint paint;

    @Override
    public Shape action(final Shape shape) {
        shape.setFill(this.paint);
        return shape;
    }

    @Override
    public FillStrategy withPaint(final Paint paint) {
        this.paint = paint;
        return this;
    }

    @Override
    public String name() {
        return "Stroke";
    }
}
