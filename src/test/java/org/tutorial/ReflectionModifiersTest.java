package org.tutorial;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;


public class ReflectionModifiersTest {

    @Test
    public void checkClassModifiers() throws ClassNotFoundException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        int modifiers = clazz.getModifiers();

        // then
        assertTrue(Modifier.isPublic(modifiers));
    }

    @Test
    public void checkPrivateMethodModifiers() throws ClassNotFoundException, NoSuchMethodException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Method privateChildMethod = clazz.getDeclaredMethod("getPrivateFieldPrivateMethod");

        // then
        assertTrue(Modifier.isPrivate(privateChildMethod.getModifiers()));
    }

    @Test
    public void checkProtectedMethodModifiers() throws ClassNotFoundException, NoSuchMethodException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Method privateChildMethod = clazz.getDeclaredMethod("protectedChildMethod");

        // then
        assertTrue(Modifier.isProtected(privateChildMethod.getModifiers()));
    }

    @Test
    public void checkPrivateFieldModifier() throws ClassNotFoundException, NoSuchFieldException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Field privateField = clazz.getDeclaredField("privateField");

        // then
        assertTrue(Modifier.isPrivate(privateField.getModifiers()));
    }

    @Test
    public void checkStaticFieldModifier() throws ClassNotFoundException, NoSuchFieldException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Field privateField = clazz.getDeclaredField("staticFinalField");

        // then
        assertTrue(Modifier.isStatic(privateField.getModifiers()));
    }

    @Test
    public void checkFinalFieldModifier() throws ClassNotFoundException, NoSuchFieldException {
        // given
        Class<?> clazz = Class.forName("org.tutorial.Child");

        // when
        Field privateField = clazz.getDeclaredField("privateFinal");

        // then
        assertTrue(Modifier.isFinal(privateField.getModifiers()));
    }
}
