//@@author aali195
package seedu.address.logic.parser.exceptions;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents an image error encountered by a parser.
 */
public class ImageException extends IllegalValueException {

    public ImageException(String message) {
        super(message);
    }

    public ImageException(String message, Throwable cause) {
        super(message, cause);
    }
}
//@@author
