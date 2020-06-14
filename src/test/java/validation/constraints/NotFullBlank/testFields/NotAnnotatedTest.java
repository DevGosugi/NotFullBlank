package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class NotAnnotatedTest {
    private String notAnnotated="a";

    @NotFullBlank
    private String annotated="a";
}
