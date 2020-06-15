package validation.constraints.NotFullBlank.annotations;

//import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// https://qiita.com/y_tochukaso/items/86e10bda6bbefbdaf983
// https://qiita.com/opengl-8080/items/3926fbde5469c0b330c2#%E8%87%AA%E4%BD%9C%E3%81%AE%E3%83%90%E3%83%AA%E3%83%87%E3%83%BC%E3%82%BF%E3%81%A8%E5%88%B6%E7%B4%84%E3%82%A2%E3%83%8E%E3%83%86%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotFullBlank {}
