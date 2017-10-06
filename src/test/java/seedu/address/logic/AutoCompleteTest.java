package seedu.address.logic;

import org.junit.Before;
import org.junit.Test;

import seedu.address.logic.trie.CommandTrie;
import seedu.address.logic.trie.Trie;

/**
 * Test Class for autocomplete function
 */
public class AutoCompleteTest {

    private Trie commandTrie;

    @Before
    public void setup(){
        commandTrie = new CommandTrie();
    }

    @Test
    public void testAutoComplete(){
        assert commandTrie.attemptAutoComplete("a").equals("add");
        assert commandTrie.attemptAutoComplete("e").equals("e");
        assert commandTrie.attemptAutoComplete("ed").equals("edit");
        assert commandTrie.attemptAutoComplete("ex").equals("exit");
        assert commandTrie.attemptAutoComplete("H").equals("H");
        assert commandTrie.attemptAutoComplete("He").equals("help");
    }

}
