package com.alic;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author suxingzhe
 * @create 2018-06-10 上午11:22
 **/
public class ObserverTest {
    private void myMethod(){
        System.out.println("myMethod called!");
    }

    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.alic.ObserverTest");
        Method myMethod = aClass.getDeclaredMethod("myMethod");
        myMethod.setAccessible(true);
        myMethod.invoke(new ObserverTest());
    }
}
