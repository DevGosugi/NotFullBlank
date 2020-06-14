package validation.constraints.NotFullBlank.testFields;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;

public class ValidTest {
    @NotFullBlank
    private String test1="aa　あa";

    @NotFullBlank
    private String test2="   a";

    @NotFullBlank
    private String test3="\n    \n\na\n";
}
