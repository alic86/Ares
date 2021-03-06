package com.alic.validation.constraints;

import com.alic.validation.CardNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 卡号校验
 *
 * @author suxingzhe
 * @create 2018-06-08 下午8:40
 **/
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(
        validatedBy = {CardNumberConstraintValidator.class}
)
public @interface CardNumberValidation {
    String message() default "{com.alic.domain.validation.invalid.card.number.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
