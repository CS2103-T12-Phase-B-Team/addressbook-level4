package seedu.address.model.person;

import seedu.address.commons.exceptions.IllegalValueException;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Person's expiry date in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidExpiryDate(String)}
 */
public class ExpiryDate {

    public static final String MESSAGE_EXPIRY_DATE_CONSTRAINTS =
            "Person's expiry date should be dates later than current date, in the form of YYYY-MM-DD";

    /*
     * Date format is YYYY-MM-DD
     */
    public static final String DATE_VALIDATION_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

    public final Date value;

    /**
     * Validates given date.
     *     Input string can be empty (expiry date = NULL)
     *
     * @throws IllegalValueException if given date string is invalid.
     */
    public ExpiryDate(String date) throws IllegalValueException {
        if (date == "") {
            this.value = null;
            return;
        }
        else if (!isValidExpiryDate(date)) {
            throw new IllegalValueException(MESSAGE_EXPIRY_DATE_CONSTRAINTS);
        }
        // should catch invalid month/day combination
        ParsePosition parsePos = new ParsePosition(0);
        this.value = dateFormatter.parse(date, parsePos);

        // date formatter parse error
        if(parsePos.getIndex() == 0) {
            throw new IllegalValueException(MESSAGE_EXPIRY_DATE_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid date format.
     */
    public static boolean isValidExpiryDate(String test) {
        return test.matches(DATE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return dateFormatter.format(value);
    }

    //TODO: override equals and hashCode (?)

}
