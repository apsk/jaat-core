package apsk.jaat.core.aggregator;

@FunctionalInterface
public interface AggregatorFactory {
    public Aggregator create();
}
