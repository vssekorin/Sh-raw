package shraw;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.val;
import shraw.fill.AsStroke;
import shraw.fill.FillStrategy;
import shraw.fill.Stroke;
import shraw.fill.WithStroke;
import shraw.model.Circle;
import shraw.model.Rectangle;
import shraw.model.Shape;
import shraw.model.StylishShape;

import java.util.Arrays;

/**
 * Контроллер.
 */
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

    /**
     * Состояние.
     */
    private State state = new State();

    @FXML
    void initialize() {
        this.style.getItems().addAll(
            Arrays.asList(new Stroke(Color.BLACK), new AsStroke(Color.BLACK), new WithStroke(Color.BLACK))
        );
        this.style.setConverter(new NamedStringConverter<>());
        this.style.getSelectionModel().selectFirst();

        this.figures.getItems().addAll(
            Arrays.asList(new Rectangle(0, 0), new Circle(0, 0))
        );
        this.figures.setConverter(new NamedStringConverter<>());
        this.figures.getSelectionModel().selectFirst();
    }

    /**
     * Кнопка мыши зажата.
     *
     * @param event Событие мыши
     */
    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.startMove(event.getX(), event.getY());
        } else {
            val shape = new StylishShape(
                this.figures.getValue().with(event.getX(), event.getY()),
                this.style.getValue().withPaint(this.colors.getValue())
            );
            this.state.setCurrent(shape);
            this.paint.getChildren().add(shape.asShapeFX());
        }
    }

    /**
     * Перемещение кнопки мыши.
     *
     * @param event Событие мыши
     */
    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.dragMove(event.getX(), event.getY());
        } else {
            this.state.updateCurrent(event.getX(), event.getY());
        }
    }

    /**
     * Кнопка мыши отжата.
     *
     * @param event Событие мыши
     */
    public void mReleased(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.state.addMove(event.getX(), event.getY());
        } else {
            this.state.addNew();
        }
    }

    /**
     * Отмена действия.
     */
    public void undo() {
        this.state.undo();
    }

    /**
     * Возвращения действия.
     */
    public void redo() {
        this.state.redo();
    }

    /**
     * Выход.
     */
    public void exit() {
        Platform.exit();
    }
}
