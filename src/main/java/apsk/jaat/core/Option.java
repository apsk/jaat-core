package apsk.jaat.core;

import java.util.Arrays;
import java.util.function.Predicate;

public class Option {
    public enum Type {
        Integral,
        Floating,
        String,
        Variant,
        Custom
    }
    public final String name;
    public final Type type;
    public final String[] alternatives;
    public final Predicate<String> validator;
    private Option(
        String name,
        Type type,
        String[] alternatives,
        Predicate<String> validator
    ) {
        this.name = name;
        this.type = type;
        this.alternatives = alternatives;
        this.validator = validator;
    }
    public boolean validate(String value) {
        return validator.test(value);
    }
    public static Option integral(String name) {
        return new Option(name, Type.Integral, null, integralValidator);
    }
    public static Option floating(String name) {
        return new Option(name, Type.Floating, null, floatingValidator);
    }
    public static Option string(String name) {
        return new Option(name, Type.String, null, val -> true);
    }
    public static Option variant(String name, String[] alternatives) {
        return new Option(name, Type.Variant, alternatives, val ->
            Arrays.asList(alternatives).contains(val)
        );
    }
    public static Option custom(String name, Predicate<String> validator) {
        return new Option(name, Type.Custom, null, validator);
    }
    private static Predicate<String> integralValidator = val -> {
        try { Integer.parseInt(val); return true; }
        catch (NumberFormatException e) { return false; }
    };
    private static Predicate<String> floatingValidator = val -> {
        try { Float.parseFloat(val); return true; }
        catch (NumberFormatException e) { return false; }
    };
}
