package shraw.fill;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Стратегия расскраски. Цветная граница.
 */
public final class AsStroke implements FillStrategy {

    /**
     * Раскраска.
     */
    private final Paint color;

    /**
     * Ctor.
     * @param paint Раскраска
     */
    public AsStroke(final Paint paint) {
        this.color = paint;
    }

    @Override
    public Shape apply(final Shape shape) {
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
