package apsk.jaat.core.option.validation;

import apsk.jaat.core.option.Type;

public class ValidationException extends Exception {
    public ValidationException(Type type, String msg) {
        super(type.name() + " validation fail: " + msg);
    }
}
