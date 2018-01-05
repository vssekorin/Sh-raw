package shraw.model;

import javafx.util.StringConverter;

import java.util.stream.Stream;

public class ShapeStringConverter extends StringConverter<Shape> {

    @Override
    public String toString(final Shape shape) {
        return shape.name();
    }

    @Override
    public Shape fromString(final String name) {
        return Stream.of(new Rectangle(0, 0), new Circle(0, 0))
            .filter(shape -> shape.name().equals(name))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
