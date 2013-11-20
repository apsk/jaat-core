package apsk.jaat.core.option.validation;

@FunctionalInterface
public interface Validator {
    public void validate(String value) throws ValidationException;
}
