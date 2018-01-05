package shraw.fill;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import shraw.Named;

public interface FillStrategy extends Named {

    Shape action(Shape shape);

    FillStrategy withPaint(Paint paint);
}
