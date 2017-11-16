package shraw;

import javafx.application.Platform;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.model.Rectangle;
import shraw.model.Shape;
import shraw.model.Shapes;

public final class Controller {
    public Pane paint;
    public ChoiceBox choice;

    private Shapes shapes = new Shapes();
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
        this.shapes.get().forEach(this.paint.getChildren()::add);
        this.paint.getChildren().add(this.shape.asJavaFXShape());
    }

    public void close() {
        Platform.exit();
    }
}
