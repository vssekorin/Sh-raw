package shraw.activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Activities {

    private final List<Activity> performed;
    private final List<Activity> undone;

    public Activities() {
        this.performed = new ArrayList<>();
        this.undone = new LinkedList<>();
    }

    public void add(final Activity activity) {
        this.performed.add(activity);
        this.undone.clear();
    }

    public Activity forUndo() {
        return this.swapAction(this.performed, this.undone);
    }

    public Activity forRedo() {
        return this.swapAction(this.undone, this.performed);
    }

    private Activity swapAction(final List<Activity> first,
                                final List<Activity> second) {
        final int size = first.size();
        final Activity activity = first.get(size - 1);
        second.add(activity);
        first.remove(size - 1);
        return activity;
    }
}
