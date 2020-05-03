package io.mixelx.spacefm.validation.annotations;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static io.mixelx.spacefm.utils.Constants.UNIQUE_USERNAME;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueUsername {

    String message() default UNIQUE_USERNAME;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
