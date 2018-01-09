package shraw.fill;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Стратегия расскраски. Залитая фигура с черной границей.
 */
public final class WithStroke implements FillStrategy {

    /**
     * Раскраска.
     */
    private final Paint color;

    /**
     * Ctor.
     * @param paint Раскраска
     */
    public WithStroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape apply(final Shape shape) {
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
