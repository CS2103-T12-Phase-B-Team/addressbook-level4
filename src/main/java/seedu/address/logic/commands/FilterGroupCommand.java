package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.GroupContainsKeywordsPredicate;

public class FilterGroupCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + "Filters the displayed addressbook to present only the" +
            "people in the group entered. Example: "+ COMMAND_WORD + "Ho Chi Minh Tour Group";

    public static final String MESSAGE_PARAMETERS = "[Group]";

    private GroupContainsKeywordsPredicate predicate;

    public FilterGroupCommand (GroupContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        model.updateFilteredPersonList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals (Object other) {
        return other == this // short circuit if same object
                || (other instanceof FilterGroupCommand // instanceof handles nulls
                && predicate.equals(((FilterGroupCommand) other).predicate));
    }

}
