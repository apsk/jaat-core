package apsk.jaat.core.option.template;

import apsk.jaat.core.option.Option;
import apsk.jaat.core.option.validation.ValidationException;
import apsk.jaat.core.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class OptionManager {
    final Map<String, Pair<Option, String>> options;
    public OptionManager(Option[] options) {
        this.options = new HashMap<>();
        for (Option o : options)
            this.options.put(o.name,
                new Pair<>(o, null)
            );
    }
    public String get(String name) {
        return options.get(name).snd;
    }
    public void set(String name, String value) throws ValidationException {
        Pair<Option, String> ovp = options.get(name);
        ovp.fst.validate(value);
        ovp.snd = value;
    }
    public Stream<Option> stream() {
        return options.values().stream().map(ovp -> ovp.fst);
    }
}
