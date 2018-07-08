package com.alic;

import org.junit.Test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author suxingzhe
 * @create 2018-06-23 下午2:50
 **/
public class UnitTest {
    @Test
    public void test01(){
        MethodType mt = MethodType.methodType(String.class);
        MethodHandles.Lookup lk = MethodHandles.lookup();
        try {
            lk.findVirtual(getClass(), "toString", mt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
