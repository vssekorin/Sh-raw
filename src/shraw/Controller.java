package shraw;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.fill.*;
import shraw.model.Circle;
import shraw.model.Rectangle;
import shraw.model.Shape;
import shraw.model.ShapeStringConverter;

import java.util.Arrays;
import java.util.List;

public final class Controller {

    @FXML
    private ToggleButton toggle;
    @FXML
    private Pane paint;
    @FXML
    private ColorPicker colors;
    @FXML
    private ComboBox<FillStrategy> style;
    @FXML
    private ComboBox<Shape> figures;

    private State state = new State();

    @FXML
    void initialize() {
        final List<FillStrategy> strategies = Arrays.asList(
            new Stroke(),
            new AsStroke(),
            new WithStroke()
        );
        this.style.getItems().addAll(strategies);
        this.style.setConverter(new StrategyStringConverter());
        this.style.getSelectionModel().selectFirst();

        final List<Shape> shapes = Arrays.asList(
            new Rectangle(0, 0),
            new Circle(0, 0)
        );
        this.figures.getItems().addAll(shapes);
        this.figures.setConverter(new ShapeStringConverter());
        this.figures.getSelectionModel().selectFirst();
    }

    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.startMove(event.getX(), event.getY());
        } else {
            final Shape newShape = this.figures.getValue().like(
                event.getX(),
                event.getY(),
                this.style.getValue().withPaint(this.colors.getValue())
            );
            this.state.setCurrent(newShape);
            this.paint.getChildren().add(newShape.asJavaFXShape());
        }
    }

    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.dragMove(event.getX(), event.getY());
        } else {
            this.state.updateCurrent(event.getX(), event.getY());
        }
    }

    public void mReleased(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.addMove(event.getX(), event.getY());
        } else {
            this.state.addNew();
        }
    }

    public void undo() {
        this.state.undo();
    }

    public void redo() {
        this.state.redo();
    }

    public void exit() {
        Platform.exit();
    }
}
