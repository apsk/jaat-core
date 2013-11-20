package apsk.jaat.core.aggregator;

import apsk.jaat.core.option.Option;
import apsk.jaat.core.option.validation.ValidationException;
import javafx.beans.property.BooleanProperty;

import java.util.Map;
import java.util.stream.Stream;

public interface Aggregator {
    String getName();
    String getVersion();
    String getResource();
    Stream<Option> getOptions();
    String getOption(String name);
    void setOption(String name, String value) throws ValidationException;
    Map<String, String> receiveData();
    BooleanProperty isActive();
}
