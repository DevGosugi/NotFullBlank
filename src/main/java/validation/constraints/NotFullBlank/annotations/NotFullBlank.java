package validation.constraints.NotFullBlank.annotations;

//import javax.validation.constraints.NotBlank;
import validation.constraints.NotFullBlank.NotFullBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// https://qiita.com/y_tochukaso/items/86e10bda6bbefbdaf983
// http://enterprisegeeks.hatenablog.com/entry/2016/02/29/072811
// https://qiita.com/opengl-8080/items/3926fbde5469c0b330c2#%E8%87%AA%E4%BD%9C%E3%81%AE%E3%83%90%E3%83%AA%E3%83%87%E3%83%BC%E3%82%BF%E3%81%A8%E5%88%B6%E7%B4%84%E3%82%A2%E3%83%8E%E3%83%86%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B
// https://ti-tomo-knowledge.hatenablog.com/entry/2018/06/18/094526

//@Documented
@Constraint(validatedBy = {NotFullBlankValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
        ElementType.ANNOTATION_TYPE,
        ElementType.PARAMETER,
        ElementType.TYPE_USE})
public @interface NotFullBlank {
    String message() default "{validation.constrains.NotFullBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD,
            ElementType.METHOD,
            ElementType.CONSTRUCTOR,
            ElementType.ANNOTATION_TYPE,
            ElementType.PARAMETER,
            ElementType.TYPE_USE})
    @Documented
    public @interface List {
        NotFullBlank[] value();
    }
}
