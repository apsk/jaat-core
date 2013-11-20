package apsk.jaat.core.option;

import apsk.jaat.core.option.validation.*;
import java.util.Arrays;

public class Option {
    public final String name;
    public final Type type;
    public final String[] alternatives;
    public final Validator validator;
    private Option(
        String name,
        Type type,
        String[] alternatives,
        Validator validator
    ) {
        this.name = name;
        this.type = type;
        this.alternatives = alternatives;
        this.validator = validator;
    }
    public void validate(String value) throws ValidationException {
        validator.validate(value);
    }
    public static Option integral(String name) {
        return new Option(name, Type.Integral, null, integralValidator);
    }
    public static Option floating(String name) {
        return new Option(name, Type.Floating, null, floatingValidator);
    }
    public static Option string(String name) {
        return new Option(name, Type.String, null, val -> {});
    }
    public static Option variant(String name, String[] alternatives) {
        return new Option(name, Type.Variant, alternatives, val ->
            Arrays.asList(alternatives).contains(val)
        );
    }
    public static Option custom(String name, Validator validator) {
        return new Option(name, Type.Custom, null, validator);
    }
    private static Validator integralValidator = val -> {
        try { Integer.parseInt(val); }
        catch (NumberFormatException e) {
            throw new ValidationException(Type.Integral, e.getMessage());
        }
    };
    private static Validator floatingValidator = val -> {
        try { Float.parseFloat(val); }
        catch (NumberFormatException e) {
            throw new ValidationException(Type.Floating, e.getMessage());
        }
    };
}
