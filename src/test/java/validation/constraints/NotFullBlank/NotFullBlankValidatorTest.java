package validation.constraints.NotFullBlank;

import org.junit.jupiter.api.Test;
import validation.constraints.NotFullBlank.exceptions.FullBlankException;
import validation.constraints.NotFullBlank.exceptions.NotStringException;
import validation.constraints.NotFullBlank.testFields.*;

import static org.junit.jupiter.api.Assertions.*;

class NotFullBlankExecutorTest {
    @Test
    public void test() {
        NotFullBlankValidator fb = NotFullBlankValidator.getInstance();
        assertAll(
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.execute(new HalfBlanksTest())
                        ).getMessage()
                ), // HalfBlanks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.execute(new FullBlanksTest())
                        ).getMessage()
                ), // FullBlanks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.execute(new BreaksTest())
                        ).getMessage()
                ), // Breaks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.execute(new TabsTest())
                        ).getMessage()
                ), // Tabs
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.execute(new AllFullBlanksTest())
                        ).getMessage()
                ), // AllFullBlanks
                () -> assertEquals(
                        fb,
                        fb.execute(new NotAnnotatedTest())
                ), // NotAnnotated
                () -> assertEquals(
                        "Field 'notString' is not type String.",
                        assertThrows(
                                NotStringException.class,
                                () -> fb.execute(new NotStringTest())
                        ).getMessage()
                ), // NotString
                () -> assertEquals(
                        fb,
                        fb.execute(new ValidTest())
                ), // Valid
                () -> assertEquals(
                        fb,
                        fb.execute(new NotAnnotatedTest())
                                .execute(new ValidTest())
                ) // NotAnnotated.Valid
        );
    }
}