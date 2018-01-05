package shraw;

import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.List;

public final class ComboBoxFirstDefault<T> extends ComboBox<T> {

    ComboBoxFirstDefault(List<T> items, StringConverter<T> converter) {
        super();
        this.getItems().addAll(items);
        this.setConverter(converter);
        this.getSelectionModel().selectFirst();
    }
}
