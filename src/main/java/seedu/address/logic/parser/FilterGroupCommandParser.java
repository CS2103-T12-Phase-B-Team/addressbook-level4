package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FilterGroupCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.GroupContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;

public class FilterGroupCommandParser implements Parser<FilterGroupCommand> {
    @Override
    public FilterGroupCommand parse(String userInput) throws ParseException {
        String trimmedArgs = userInput.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterGroupCommand.MESSAGE_USAGE));
        } else if (trimmedArgs.length() > 1 ){
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterGroupCommand.MESSAGE_USAGE));
        }

        return new FilterGroupCommand(new GroupContainsKeywordsPredicate(trimmedArgs));
    }
}
