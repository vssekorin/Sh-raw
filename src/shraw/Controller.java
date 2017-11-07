package shraw;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public final class Controller {

    public void close(final ActionEvent event) {
        Platform.exit();
    }
}
