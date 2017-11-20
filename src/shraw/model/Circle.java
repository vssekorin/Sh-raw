package shraw.model;

import javafx.scene.input.MouseEvent;

import static java.lang.Math.pow;

public class Circle implements Shape {

    private double pointX;

    private double pointY;

    private double radius;

    public Circle(final double eventX, final double eventY) {
        this.pointX = eventX;
        this.pointY = eventY;
        this.radius = 0;
    }
    @Override
    public void update(MouseEvent event) {
        radius = pow(pow(pointX - event.getX(), 2) + pow(pointY - event.getY(), 2), 0.5);
    }

    @Override
    public void move(MouseEvent event,double x, double y) {
        pointX = pointX + event.getX() - x;
        pointY = pointY + event.getY() - y;

    }

    @Override
    public javafx.scene.shape.Shape asJavaFXShape() {
        return new javafx.scene.shape.Circle(pointX, pointY, radius);
    }
}
