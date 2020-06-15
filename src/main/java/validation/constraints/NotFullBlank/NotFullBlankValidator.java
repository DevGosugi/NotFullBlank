package validation.constraints.NotFullBlank;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;
import validation.constraints.NotFullBlank.exceptions.FullBlankException;
import validation.constraints.NotFullBlank.exceptions.NotStringException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class NotFullBlankValidator implements ConstraintValidator<NotFullBlank, String> {
    private static final NotFullBlankValidator INSTANCE = new NotFullBlankValidator();
    private NotFullBlankValidator() {}
    public static NotFullBlankValidator getInstance() {
        return INSTANCE;
    }

    private final String REGEXP = "^[ 　\n\t]+$";

    @Override
    public void initialize(NotFullBlank annotation) {}

    @Override
    public boolean isValid(String val, ConstraintValidatorContext context) {
        if(val == null) {
            return true;
        }
        return validate(val);
    }

    public boolean validate(String val) {
        Pattern pattern = Pattern.compile(this.REGEXP);
        return pattern.matcher(val).find(); // val.matches(this.REGEXP)
    }

    public NotFullBlankValidator multiValidate(Object obj) throws
            IllegalAccessException, FullBlankException,
            NotStringException {
        Pattern pattern = Pattern.compile(this.REGEXP);

        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field f: fields) {
            if(!f.isAnnotationPresent(NotFullBlank.class)) {
                // NotFullBlankアノテーションが付与されていなければ
                continue;
            }
            if(!f.getType().equals(String.class)) {
                // 文字列型の入力でなければ
                throw new NotStringException("Field '" + f.getName() + "' is not type String.");
            }
            f.setAccessible(true);
            String val = f.get(obj).toString();
            if(pattern.matcher(val).find()) { // if(val.matches(this.REGEXP))
                throw new FullBlankException("Field '" + f.getName() + "' consists of half-width spaces, full-width spaces, line breaks, or tabs.");
            }
        }
        return INSTANCE;
    }
}
