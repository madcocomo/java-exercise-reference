package code.practices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgumentTest {
    @Test
    public void should_get_up_limit() {
        Argument argument = new Argument(new String[]{"20"});
        assertEquals(20, argument.getUpLimit());
    }

    @Test
    public void should_get_default_up_limit_when_no_arguments() {
        Argument argument = new Argument(new String[]{});
        assertEquals(Argument.DEFAULT_UP_LIMIT, argument.getUpLimit());
    }

    @Test
    public void should_ignore_additional_arguments() {
        Argument argument = new Argument(new String[]{"15", "dontcare"});
        assertEquals(15, argument.getUpLimit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_1st_argument_is_not_number() {
        Argument argument = new Argument(new String[]{"dontcare"});
    }
}
