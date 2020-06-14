package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class HalfBlanksTest {
    @NotFullBlank
    private String valid="a";

    @NotFullBlank
    private String invalid="     ";

    public HalfBlanksTest() {}
}
