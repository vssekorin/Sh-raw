package shraw.fill;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Стратегия расскраски. Залитая фигура.
 */
public final class Stroke implements FillStrategy {

    /**
     * Раскраска.
     */
    private final Paint color;

    /**
     * Ctor.
     * @param paint Раскраска
     */
    public Stroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape apply(final Shape shape) {
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
