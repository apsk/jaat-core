package apsk.jaat.core;

public class Option {
    public enum Type {
        Integral,
        Floating,
        String,
        Variant
    };
    public final String name;
    public final Type type;
    public final String[] alternatives;
    public Option(String name, Type type) {
        this.name = name;
        this.type = type;
        this.alternatives = null;
    }
    public Option(String name, String[] alternatives) {
        this.name = name;
        this.type = Type.Variant;
        this.alternatives = alternatives;
    }
    public Option(String name) {
        this(name, Type.String);
    }
}
