package validation.constraints.NotFullBlank;

import org.junit.jupiter.api.Test;
import validation.constraints.NotFullBlank.exceptions.FullBlankException;
import validation.constraints.NotFullBlank.exceptions.NotStringException;
import validation.constraints.NotFullBlank.testFields.*;

import static org.junit.jupiter.api.Assertions.*;

class NotFullBlankValidatorTest {
    @Test
    public void testMultiValidate() {
        NotFullBlankValidator fb = NotFullBlankValidator.getInstance();
        assertAll(
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.multiValidate(new HalfBlanksTest())
                        ).getMessage()
                ), // HalfBlanks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.multiValidate(new FullBlanksTest())
                        ).getMessage()
                ), // FullBlanks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.multiValidate(new BreaksTest())
                        ).getMessage()
                ), // Breaks
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.multiValidate(new TabsTest())
                        ).getMessage()
                ), // Tabs
                () -> assertEquals(
                        "Field 'invalid' consists of half-width spaces, full-width spaces, line breaks, or tabs.",
                        assertThrows(
                                FullBlankException.class,
                                () -> fb.multiValidate(new AllFullBlanksTest())
                        ).getMessage()
                ), // AllFullBlanks
                () -> assertEquals(
                        fb,
                        fb.multiValidate(new NotAnnotatedTest())
                ), // NotAnnotated
                () -> assertEquals(
                        "Field 'notString' is not type String.",
                        assertThrows(
                                NotStringException.class,
                                () -> fb.multiValidate(new NotStringTest())
                        ).getMessage()
                ), // NotString
                () -> assertEquals(
                        fb,
                        fb.multiValidate(new ValidTest())
                ), // Valid
                () -> assertEquals(
                        fb,
                        fb.multiValidate(new NotAnnotatedTest())
                                .multiValidate(new ValidTest())
                ) // NotAnnotated.Valid
        );
    }
}