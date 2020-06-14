package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class BreaksTest {
    @NotFullBlank
    private String valid="a";

    @NotFullBlank
    private String invalid="\n\n\n";

    public BreaksTest() {}
}
