package apsk.jaat.core.service;

import apsk.jaat.core.Option;
import javafx.beans.property.BooleanProperty;

import java.util.Map;
import java.util.stream.Stream;

public interface Aggregator {
    String getName();
    String getVersion();
    String getResource();
    Stream<Option> getOptions();
    String getOption(String name);
    void setOption(String name, String value);
    Map<String, String> receiveData();
    BooleanProperty isActive();
}
