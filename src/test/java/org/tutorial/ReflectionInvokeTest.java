package org.tutorial;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

/**
 * Invoca constructori, metode, cu tipul de acces public, private, static
 * folosind java reflection
 */

public class ReflectionInvokeTest {

    @Test
    public void invokePublicConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Constructor<?> publicConstructor = clazz.getDeclaredConstructor();
        Child child = (Child) publicConstructor.newInstance();

        // then
        assertTrue(Modifier.isPublic(publicConstructor.getModifiers()));
        assertNotNull(child);
    }

    @Test
    public void invokePrivateConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Constructor<?> privateConstructor = clazz.getDeclaredConstructor(String.class);
        privateConstructor.setAccessible(true);
        Child child = (Child) privateConstructor.newInstance("test");

        // then
        assertTrue(Modifier.isPrivate(privateConstructor.getModifiers()));
        assertNotNull(child);
    }

    @Test
    public void invokePublicMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Child child = new Child();
        child.setPrivateField("test");
        Method publicMethod = Child.class.getDeclaredMethod("getPrivateField");

        // when
        String result = (String) publicMethod.invoke(child);

        // then
        assertEquals("test", result);
    }

    @Test
    public void invokePrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Child child = new Child();
        child.setPrivateField("test");
        Method privateMethod = Child.class.getDeclaredMethod("getPrivateFieldPrivateMethod");
        privateMethod.setAccessible(true);

        // when
        String result = (String) privateMethod.invoke(child);

        // then
        assertEquals("test", result);
    }

    @Test
    public void invokeStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Child child = new Child();
        Method staticMethod = Child.class.getDeclaredMethod("staticMethod", String.class);

        // when
        String result = (String) staticMethod.invoke(child, "Hello from static method!");

        // then
        assertEquals("Hello from static method!", result);
    }
}
