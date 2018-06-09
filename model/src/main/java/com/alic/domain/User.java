package com.alic.domain;

import com.alic.validation.constraints.CardNumberValidation;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author suxingzhe
 * @create 2018-06-05 下午2:30
 **/
@Data
public class User  {
    @Max(value = 10000)
    private Long id;

    private String name;

    private Integer age;

    @NotNull
    @CardNumberValidation
    private String cardNumber;

    public User(){}
}
