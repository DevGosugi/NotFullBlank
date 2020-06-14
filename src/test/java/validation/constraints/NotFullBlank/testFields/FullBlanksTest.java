package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class FullBlanksTest {
    @NotFullBlank
    private String valid="あ";

    @NotFullBlank
    private String invalid="　　　";

    public FullBlanksTest() {}
}
