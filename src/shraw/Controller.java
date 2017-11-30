package shraw;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import shraw.model.Rectangle;
import shraw.model.Shape;

import java.util.function.Function;

public final class Controller {
    public Pane paint;
    public ChoiceBox choice;
    public ToggleButton toggle;
    public ColorPicker colors;
    public ComboBox<Function<Paint,
        Function<javafx.scene.shape.Shape, javafx.scene.shape.Shape>>> style;

    private State state = new State();
    private Shape shape = null;
    private double pointX = 0;
    private double pointY = 0;
    private Rectangle rect = null;

    @FXML
    public void initialize() {
        this.style.getItems().addAll(FillStrategy.all);
        this.style.setConverter(FillStrategy.stringConverter);
    }

    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.pointX = event.getX();
            this.pointY = event.getY();
            this.shape = this.state.figure(this.pointX, this.pointY)
                .orElse(this.shape);
        } else {
            this.rect = new Rectangle(event.getX(), event.getY());
            this.paint.getChildren().add(this.rect.asJavaFXShape());
        }
    }

    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.rect.move(pointX - event.getX(), pointY - event.getY());
            this.pointX = event.getX();
            this.pointY = event.getY();
        } else {
            this.rect.update(event.getX(), event.getY());
        }
    }

    public void mReleased() {
        this.state.addNew(this.rect);
    }

    public void undo() {
        this.state.undo();
    }

    public void redo() {
        this.state.redo();
    }
}
