package shraw.model;

import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author VsSekorin
 */
public final class Shapes {

    private final List<Shape> shapes = new ArrayList<>();

    public Stream<javafx.scene.shape.Shape> get() {
        return this.shapes.stream().map(Shape::asJavaFXShape);
    }

    public void add(final Shape shape) {
        this.shapes.add(shape);
    }

    public Shape find(final MouseEvent event) {
        return this.shapes.stream()
            .filter(Shape.contains(event.getX(), event.getY()))
            .findFirst()
            .orElse(null);
    }

    public void clear(){
        shapes.clear();
    }
}
