package shraw;

import lombok.Setter;
import shraw.activity.Activities;
import shraw.activity.CreateShape;
import shraw.activity.MoveShape;
import shraw.model.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class State {

    private final List<Shape> shapes;
    private final Activities activities;
    @Setter
    private Shape current;
    private double prevX;
    private double prevY;
    private double startY;
    private double startX;

    public State() {
        this.shapes = new ArrayList<>();
        this.activities = new Activities();
    }

    public void addNew() {
        this.shapes.add(current);
        this.activities.add(new CreateShape(current));
    }

    public void addMove(final double x, final double y) {
        this.activities.add(new MoveShape(current, x - startX, y - startY));
    }

    public void undo() {
        this.activities.forUndo().undo();
    }

    public void redo() {
        this.activities.forRedo().redo();
    }

    public void startMove(final double x, final double y) {
        this.prevX = this.startX = x;
        this.prevY = this.startY = y;
        this.current = this.figure(prevX, prevY).orElse(this.current);
    }

    public void dragMove(final double x, final double y) {
        this.current.move(this.prevX - x, this.prevY - y);
        this.prevX = x;
        this.prevY = y;
    }

    public void updateCurrent(final double x, final double y) {
        this.current.update(x, y);
    }

    private Optional<Shape> figure(final double pointX, final double pointY) {
        return this.shapes.stream()
            .filter(Shape.isVisible())
            .filter(Shape.contains(pointX, pointY))
            .findFirst();
    }
}
