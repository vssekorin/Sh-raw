package shraw.fill;

import javafx.util.StringConverter;

/**
 * @author VsSekorin
 */
public final class StrategyStringConverter extends StringConverter<FillStrategy> {

    @Override
    public String toString(final FillStrategy strategy) {
        return strategy.name();
    }

    @Override
    public FillStrategy fromString(String s) {
        throw new UnsupportedOperationException();
    }
}
