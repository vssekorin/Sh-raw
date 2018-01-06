package shraw.fill;

import javafx.util.StringConverter;

public final class StrategyStringConverter extends StringConverter<FillStrategy> {

    @Override
    public String toString(final FillStrategy strategy) {
        return strategy.text();
    }

    @Override
    public FillStrategy fromString(String text) {
        throw new UnsupportedOperationException();
    }
}
