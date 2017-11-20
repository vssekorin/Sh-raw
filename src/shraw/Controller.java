package shraw;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import shraw.model.Circle;
import shraw.model.Rectangle;
import shraw.model.Shape;
import shraw.model.Shapes;

import java.util.function.Function;

public final class Controller {
    public Pane paint;
    public ChoiceBox choice;
    public ToggleButton toggle;
    public ColorPicker colors;
    public ChoiceBox strategy;

    private final Shapes shapes = new Shapes();
    private Shape shape = null;
    private double pointX = 0;
    private double pointY = 0;

    public void mPressed(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.shape = this.shapes.find(event);
            this.pointX = event.getX();
            this.pointY = event.getY();
        } else {
            this.shape = this.chooseShape(event);
        }
    }

    private Shape chooseShape(final MouseEvent event) {
        switch ((String) this.choice.getValue()) {
            case "Rectangle":
                return new Rectangle(
                    event.getX(), event.getY(), this.chooseFill()
                );
            case "Circle":
                return new Circle(
                    event.getX(), event.getY(), this.chooseFill()
                );
            default:
                throw new IllegalStateException();
        }

    }

    private Function<javafx.scene.shape.Shape, javafx.scene.shape.Shape> chooseFill() {
        switch ((String) this.strategy.getValue()) {
            case "Simple":
                return FillStrategy.simple().apply(this.colors.getValue());
            case "With stroke":
                return FillStrategy.withStroke().apply(this.colors.getValue());
            default:
                throw new IllegalStateException();
        }
    }

    public void mDragged(final MouseEvent event) {
        if (this.toggle.isSelected()) {
            this.shape.move(event, this.pointX, this.pointY);
            this.pointX = event.getX();
            this.pointY = event.getY();
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
