package shraw.fill;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import shraw.Named;

/**
 * Стратегия закраски фигуры.
 */
public interface FillStrategy extends Named {

    /**
     * Применение стратегии закраски к фигуре.
     *
     * @param shape Фигура
     * @return Измененная фигура
     */
    Shape apply(Shape shape);

    /**
     * Создание копии с указанной раскраской.
     *
     * @param paint Раскраска
     * @return Копия
     */
    FillStrategy withPaint(Paint paint);
}
