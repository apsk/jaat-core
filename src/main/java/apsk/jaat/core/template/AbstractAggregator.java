package apsk.jaat.core.template;

import apsk.jaat.core.Option;
import apsk.jaat.core.service.Aggregator;
import apsk.jaat.core.util.Pair;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public abstract class AbstractAggregator implements Aggregator {
    final BooleanProperty active = new SimpleBooleanProperty(false);
    final Map<String, Pair<Option, String>> options;
    public AbstractAggregator(List<Option> options) {
        this.options = new HashMap<>();
        options.forEach(o ->
            this.options.put(o.name,
                new Pair<>(o, null)
            )
        );
    }
    @Override
    public String getResource() {
        return getOption("resource");
    }
    @Override
    public Stream<Option> getOptions() {
        return options.values().stream().map(ovp -> ovp.fst);
    }
    @Override
    public String getOption(String name) {
        return options.get(name).snd;
    }
    @Override
    public void setOption(String name, String value) {
        options.get(name).snd = value;
    }
    @Override
    public BooleanProperty isActive() {
        return active;
    }
}
