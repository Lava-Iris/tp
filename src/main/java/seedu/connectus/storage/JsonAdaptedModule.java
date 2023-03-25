package seedu.connectus.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.connectus.commons.exceptions.IllegalValueException;
import seedu.connectus.model.tag.Module;

/**
 * Jackson-friendly version of {@link Module}.
 */
class JsonAdaptedModule {

    private final String moduleName;

    /**
     * Constructs a {@code JsonAdaptedModule} with the given {@code moduleName}.
     */
    @JsonCreator
    public JsonAdaptedModule(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * Converts a given {@code Module} into this class for Jackson use.
     */
    public JsonAdaptedModule(Module source) {
        this.moduleName = source.moduleName;
    }

    @JsonValue
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Converts this Jackson-friendly adapted module object into the model's {@code Module} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted module.
     */
    public Module toModelType() throws IllegalValueException {
        if (!Module.isValidModuleName(moduleName)) {
            throw new IllegalValueException(Module.MESSAGE_CONSTRAINTS);
        }
        return new Module(moduleName);
    }

}