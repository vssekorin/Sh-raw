package shraw.activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Управление действиями.
 */
public final class Activities {

    /**
     * Выполненные действия.
     */
    private final List<Activity> performed;

    /**
     * Отмененные действия.
     */
    private final List<Activity> undone;

    /**
     * Ctor.
     */
    public Activities() {
        this.performed = new ArrayList<>();
        this.undone = new LinkedList<>();
    }

    /**
     * Добавление нового действия.
     *
     * @param activity Действие
     */
    public void add(final Activity activity) {
        this.performed.add(activity);
        this.undone.clear();
    }

    /**
     * Возвращает действие для отмены.
     *
     * @return Действие
     */
    public Activity forUndo() {
        return this.swapAction(this.performed, this.undone);
    }

    /**
     * Возвращает действие для восстановления.
     *
     * @return Действие
     */
    public Activity forRedo() {
        return this.swapAction(this.undone, this.performed);
    }

    /**
     * Переносит действия из первого списка во второй и возвращает его.
     *
     * @param first Первый список
     * @param second Второй список
     * @return Действие
     */
    private Activity swapAction(final List<Activity> first,
                                final List<Activity> second) {
        final int size = first.size();
        final Activity activity = first.get(size - 1);
        second.add(activity);
        first.remove(size - 1);
        return activity;
    }
}
