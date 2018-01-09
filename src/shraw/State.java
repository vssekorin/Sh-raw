package shraw;

import shraw.activity.Activities;
import shraw.activity.CreateShape;
import shraw.activity.MoveShape;
import shraw.model.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Состояние.
 */
public final class State {

    /**
     * Фигуры.
     */
    private final List<Shape> shapes;

    /**
     * Управление действиями.
     */
    private final Activities activities;

    /**
     * Текущая фигура.
     */
    private Shape current;

    /**
     * Предыдущие координаты.
     */
    private double prevX;
    private double prevY;

    /**
     * Начальные координаты.
     */
    private double startX;
    private double startY;

    /**
     * Ctor.
     */
    public State() {
        this.shapes = new ArrayList<>();
        this.activities = new Activities();
    }

    /**
     * Окончание создания новой фигуры.
     */
    public void addNew() {
        this.shapes.add(this.current);
        this.activities.add(new CreateShape(this.current));
    }

    /**
     * Окончание перемещения фигуры.
     *
     * @param x Новая координата x
     * @param y Новая координата y
     */
    public void addMove(final double x, final double y) {
        this.activities.add(new MoveShape(current, x - startX, y - startY));
    }

    /**
     * Отмена действия.
     */
    public void undo() {
        this.activities.forUndo().undo();
    }

    /**
     * Возвращение действия.
     */
    public void redo() {
        this.activities.forRedo().redo();
    }

    /**
     * Начало перемещения фигуры.
     *
     * @param x Выбранная координата x
     * @param y Выбранная координата y
     */
    public void startMove(final double x, final double y) {
        this.prevX = this.startX = x;
        this.prevY = this.startY = y;
        this.current = this.figure(prevX, prevY).orElse(this.current);
    }

    /**
     * Перемещение фигуры.
     *
     * @param x Новая координата x
     * @param y Новая координата y
     */
    public void dragMove(final double x, final double y) {
        this.current.move(this.prevX - x, this.prevY - y);
        this.prevX = x;
        this.prevY = y;
    }

    /**
     * Изменение текущей фигуры.
     *
     * @param x Координата x
     * @param y Координата y
     */
    public void updateCurrent(final double x, final double y) {
        this.current.update(x, y);
    }

    /**
     * Находит фигуру, содержащую указанную точку.
     *
     * @param pointX Координата x
     * @param pointY Координата y
     * @return Фигура
     */
    private Optional<Shape> figure(final double pointX, final double pointY) {
        return this.shapes.stream()
            .filter(Shape.isVisible())
            .filter(Shape.contains(pointX, pointY))
            .findFirst();
    }

    /**
     * Устанавливает текущую фигуру.
     *
     * @param shape Фигура
     */
    public void setCurrent(final Shape shape) {
        this.current = shape;
    }
}
