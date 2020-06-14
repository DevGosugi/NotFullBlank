package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class NotStringTest {
    @NotFullBlank
    private String annotated="a";

    @NotFullBlank
    private Integer notString=1;
}
