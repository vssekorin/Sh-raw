package shraw.model;

import shraw.Named;

import java.util.function.Predicate;

/**
 * Фигура.
 */
public interface Shape extends Named {

    /**
     * Изменение фигуры.
     *
     * @param abscissa Координата x
     * @param ordinate Координата y
     */
    void update(double abscissa, double ordinate);

    /**
     * Перемещение фигуры.
     * @param deltaX Разница по x
     * @param deltaY Разница по y
     */
    void move(double deltaX, double deltaY);

    /**
     * Возвращает фигуру как JavaFX фигуру.
     *
     * @return JavaFX фигура
     */
    javafx.scene.shape.Shape asShapeFX();

    /**
     * Создание копии с указанными координатами.
     *
     * @param abscissa Координата x
     * @param ordinate Координата y
     * @return Копия
     */
    Shape with(double abscissa, double ordinate);

    /**
     * Предикат: принадлежат ли точки фигуре.
     *
     * @param pointX Координата x
     * @param pointY Координата y
     * @return Предикат
     */
    static Predicate<Shape> contains(final double pointX,
                                     final double pointY) {
        return shape -> shape.asShapeFX().contains(pointX, pointY);
    }

    /**
     * Предикат: отображается ли фигура.
     *
     * @return Предикат
     */
    static Predicate<Shape> isVisible() {
        return shape -> shape.asShapeFX().isVisible();
    }
}
