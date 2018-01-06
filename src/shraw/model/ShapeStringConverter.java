package shraw.model;

import javafx.util.StringConverter;

public class ShapeStringConverter extends StringConverter<Shape> {

    @Override
    public String toString(final Shape shape) {
        return shape.text();
    }

    @Override
    public Shape fromString(final String name) {
        throw new UnsupportedOperationException();
    }
}
