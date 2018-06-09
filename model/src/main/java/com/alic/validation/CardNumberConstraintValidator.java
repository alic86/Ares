package com.alic.validation;

import com.alic.validation.constraints.CardNumberValidation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * 卡号验证器
 * @author suxingzhe
 * @create 2018-06-08 下午8:50
 **/
public class CardNumberConstraintValidator implements ConstraintValidator<CardNumberValidation, String> {
    @Override
    public void initialize(CardNumberValidation constraintAnnotation) {

    }

    /**
     * 娇艳规则
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String[] parts = StringUtils.split(value, "-");

        if(ArrayUtils.getLength(parts) != 2){
            return false;
        }

        String prefix = parts[0];
        String suffix = parts[1];

        boolean isValidPrefix = Objects.equals(prefix, "Alic");
        boolean isValidSuffix = StringUtils.isNumeric(suffix);

        return isValidPrefix && isValidSuffix;
    }
}
