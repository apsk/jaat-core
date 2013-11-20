package apsk.jaat.core.aggregator.template;

import apsk.jaat.core.option.Option;
import apsk.jaat.core.aggregator.Aggregator;
import apsk.jaat.core.option.template.OptionManager;
import apsk.jaat.core.option.validation.ValidationException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.stream.Stream;

public abstract class AbstractAggregator implements Aggregator {
    final BooleanProperty active = new SimpleBooleanProperty(false);
    final OptionManager optionManager;
    public AbstractAggregator(OptionManager optionManager) {
        this.optionManager = optionManager;
    }
    @Override
    public String getResource() {
        return getOption("resource");
    }
    @Override
    public Stream<Option> getOptions() {
        return optionManager.stream();
    }
    @Override
    public String getOption(String name) {
        return optionManager.get(name);
    }
    @Override
    public void setOption(String name, String value) throws ValidationException {
        optionManager.set(name, value);
    }
    @Override
    public BooleanProperty isActive() {
        return active;
    }
}
