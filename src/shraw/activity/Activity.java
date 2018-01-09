package shraw.activity;

/**
 * Действие.
 */
public interface Activity {

    /**
     * Отмена действия.
     */
    void undo();

    /**
     * Восстановление действия.
     */
    void redo();
}
