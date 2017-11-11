package seedu.address.commons.exceptions;

//@@author aali195
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
