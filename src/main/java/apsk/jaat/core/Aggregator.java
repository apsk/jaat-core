package apsk.jaat.core;

import javafx.beans.property.BooleanProperty;

import java.util.List;

public interface Aggregator {
    String getName();
    String getVersion();
    String getResource();
    List<Option> getOptions();
    String getOptionValue(String optionName);
    List<DataItem> receiveData();
    BooleanProperty isActive();
}
