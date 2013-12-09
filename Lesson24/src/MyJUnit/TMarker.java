package MyJUnit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Annotation pointing to the test method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TMarker {
    Class<? extends Throwable> expected() default Null.class;
}

/*
 * Null class to Throwable.
 */
class Null extends Throwable{ }
