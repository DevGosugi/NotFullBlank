package validation.constraints.annotations;

//import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// https://qiita.com/y_tochukaso/items/86e10bda6bbefbdaf983
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotFullBlank {}
