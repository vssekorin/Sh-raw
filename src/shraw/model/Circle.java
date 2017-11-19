package shraw.model;

import javafx.scene.input.MouseEvent;

import static java.lang.Math.pow;

public class Circle implements Shape {

    private double x;

    private double y;

    private double radius;

    public Circle(final double eventX, final double eventY) {
        this.x = eventX;
        this.y = eventY;
        this.radius = 0;
    }
    @Override
    public void update(MouseEvent event) {
        radius = pow(pow(x - event.getX(), 2) + pow(y - event.getY(), 2), 0.5);
    }

    @Override
    public void move(MouseEvent event) {
        x = event.getX();
        y = event.getY();
    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return new javafx.scene.shape.Circle(x, y, radius);
    }
}
