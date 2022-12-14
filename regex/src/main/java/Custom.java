import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE,FIELD,METHOD,CONSTRUCTOR})

public @interface Custom {
    int value() default 10;

}
