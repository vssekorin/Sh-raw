package shraw;

import javafx.application.Platform;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.model.Rectangle;
import shraw.model.Shape;

import java.util.ArrayList;
import java.util.List;

public final class Controller {
    public Pane paint;
    public ChoiceBox choice;

    private List<Shape> shapes = new ArrayList<>();
    private Shape shape = null;

    public void mPressed(final MouseEvent event) {
        switch ((String) choice.getValue()) {
            case "Rectangle":
                this.shape = new Rectangle(event.getX(), event.getY());
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public void mReleased(final MouseEvent event) {
        this.shapes.add(this.shape);
        this.shape = null;
    }

    public void mDragged(final MouseEvent event) {
        this.shape.update(event);
        this.paint.getChildren().clear();
        this.shapes.stream()
            .map(Shape::asJavaFXShape)
            .forEach(this.paint.getChildren()::add);
        this.paint.getChildren().add(this.shape.asJavaFXShape());
    }

    public void close() {
        Platform.exit();
    }
}
