package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;
import validation.constraints.NotFullBlank.exceptions.NotStringException;

public class NotStringTest {
    @NotFullBlank
    private String annotated="a";

    @NotFullBlank
    private Integer notString=1;

    public NotStringTest() {}
}
