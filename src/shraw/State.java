package shraw;

import shraw.activity.Activity;
import shraw.activity.CreateShape;
import shraw.model.Shape;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author VsSekorin
 */
public final class State {

    private final List<Shape> shapes;
    private final List<Activity> activities;
    private final List<Activity> undone;

    public State() {
        this.shapes = new ArrayList<>();
        this.activities = new ArrayList<>();
        this.undone = new LinkedList<>();
    }

    public Optional<Shape> figure(final double pointX, final double pointY) {
        return this.shapes.stream()
            .filter(Shape.isVisible())
            .filter(Shape.contains(pointX, pointY))
            .findFirst();
    }

    public void addNew(final Shape shape) {
        this.shapes.add(shape);
        this.activities.add(new CreateShape(shape, "create"));
        this.undone.clear();
    }

    public void undo() {
        this.swapAction(this.activities, this.undone).undo();
    }

    public void redo() {
        this.swapAction(this.undone, this.activities).redo();
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
