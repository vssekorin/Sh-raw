package shraw;

import javafx.application.Platform;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.model.Rectangle;
import shraw.model.Shape;
import shraw.model.Shapes;

public final class Controller {
    public Pane paint;
    public ChoiceBox choice;
    public ToggleButton toggle;

    private Shapes shapes = new Shapes();
    private Shape shape = null;

    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.shape = this.shapes.find(event);
        } else {
            this.shape = this.chooseShape(event);
        }
    }

    private Shape chooseShape(final MouseEvent event) {
        switch ((String) choice.getValue()) {
            case "Rectangle":
                return new Rectangle(event.getX(), event.getY());
            default:
                throw new IllegalStateException();
        }
    }

    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.shape.move(event);
        } else {
            this.shape.update(event);
        }
        this.paint.getChildren().clear();
        this.shapes.get().forEach(this.paint.getChildren()::add);
        this.paint.getChildren().add(this.shape.asJavaFXShape());
    }

    public void mReleased() {
        this.shapes.add(this.shape);
        this.shape = null;
    }
}
