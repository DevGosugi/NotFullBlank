package validation.constraints.NotFullBlank;

import validation.constraints.NotFullBlank.annotations.NotFullBlank;
import validation.constraints.NotFullBlank.exceptions.FullBlankException;
import validation.constraints.NotFullBlank.exceptions.NotStringException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class NotFullBlankExecutor {
    private static final NotFullBlankExecutor INSTANCE = new NotFullBlankExecutor();
    private NotFullBlankExecutor() {}

    public static NotFullBlankExecutor getInstance() {
        return INSTANCE;
    }

    public NotFullBlankExecutor execute(Object obj) throws
            IllegalAccessException, FullBlankException,
            NotStringException {
        String regexp = "^[ 　\n\t]+$";
        Pattern pattern = Pattern.compile(regexp);

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
            if(pattern.matcher(val).find()) { // if(val.matches(regexp))
                throw new FullBlankException("Field '" + f.getName() + "' consists of half-width spaces, full-width spaces, line breaks, or tabs.");
            }
        }
        return INSTANCE;
    }
}
