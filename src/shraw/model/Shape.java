package shraw.model;

import javafx.scene.input.MouseEvent;

/**
 * @author VsSekorin
 */
public interface Shape {

    void update(MouseEvent event);

    javafx.scene.shape.Shape asJavaFXShape();
}
