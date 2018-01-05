package shraw;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.fill.*;
import shraw.fill.FillStrategy;
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
    private Shape shape;
    private double prevX;
    private double prevY;
    private double startY;
    private double startX;

    @FXML
    public void initialize() {
        final List<FillStrategy> strategies = Arrays.asList(
            new Stroke(),
            new AsStroke(),
            new WithStroke()
        );
        this.style.getItems().addAll(strategies);
        this.style.setConverter(new StrategyStringConverter());
        this.style.getSelectionModel().selectFirst();

        final List<Shape> figures = Arrays.asList(
            new Rectangle(0, 0),
            new Circle(0, 0)
        );
        this.figures.getItems().addAll(figures);
        this.figures.setConverter(new ShapeStringConverter());
        this.figures.getSelectionModel().selectFirst();
    }

    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.prevX = event.getX();
            this.prevY = event.getY();
            this.startX = event.getX();
            this.startY = event.getY();
            this.shape = this.state.figure(prevX, prevY)
                .orElse(this.shape);
        } else {
            this.shape = this.figures.getValue().like(
                event.getX(),
                event.getY(),
                this.style.getValue().withPaint(this.colors.getValue())
            );
            this.paint.getChildren().add(this.shape.asJavaFXShape());
        }
    }

    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.shape.move(
                this.prevX - event.getX(),
                this.prevY - event.getY()
            );
            this.prevX = event.getX();
            this.prevY = event.getY();
        } else {
            this.shape.update(event.getX(), event.getY());
        }
    }

    public void mReleased(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.addMove(this.shape, event.getX() - startX, event.getY() - startY);
        } else {
            this.state.addNew(this.shape);
        }
    }

    public void undo() {
        this.state.undo();
    }

    public void redo() {
        this.state.redo();
    }
}
